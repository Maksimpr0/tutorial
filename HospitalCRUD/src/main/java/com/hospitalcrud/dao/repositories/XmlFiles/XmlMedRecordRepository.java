package com.hospitalcrud.dao.repositories.XmlFiles;

import com.hospitalcrud.config.ConfigurationXml;
import com.hospitalcrud.dao.model.MedRecord;
import com.hospitalcrud.dao.model.MedRecords;
import com.hospitalcrud.dao.model.Medication;
import com.hospitalcrud.dao.repositories.MedRecordRepository;
import com.hospitalcrud.domain.model.MedRecordUI;
import jakarta.xml.bind.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Repository
@Profile("enDesarrollo")
public class XmlMedRecordRepository implements MedRecordRepository {
private final Path xmlFile;
private final JAXBContext context;
private final Marshaller marshaller;
private final Unmarshaller unmarshaller;

public XmlMedRecordRepository() throws JAXBException {
    xmlFile = Paths.get(ConfigurationXml.getInstance().getProperty("xmlMedRecordPath"));
    context = JAXBContext.newInstance(MedRecords.class);
    marshaller = context.createMarshaller();
    unmarshaller = context.createUnmarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
}

    @Override
    public List<MedRecord> getAll(int patientId) {

        MedRecords empList;

        try {
            empList = (MedRecords) unmarshaller.unmarshal(Files.newInputStream(xmlFile));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return empList.getMedRecords().stream()
                .filter(medRecord -> medRecord.getIdPatient() == patientId)
                .collect(Collectors.toList());
    }


    @Override
    public int addMedrecord(MedRecordUI medRecordUI) {
        MedRecords medRecords;

        try {
            medRecords = (MedRecords) unmarshaller.unmarshal(Files.newInputStream(xmlFile));
        } catch (JAXBException | IOException e) {
            throw new RuntimeException("Error loading existing med records", e);
        }

        int newId = medRecords.getMedRecords().stream()
                .mapToInt(MedRecord::getId)
                .max()
                .orElse(0) + 1;

        MedRecord newMedRecord = MedRecord.builder()
                .id(newId)
                .idPatient(medRecordUI.getIdPatient())
                .idDoctor(medRecordUI.getIdDoctor())
                .diagnosis(medRecordUI.getDescription())
                .date(medRecordUI.getDate())
                .medications(medRecordUI.getMedications().stream()
                        .map(med -> new Medication(0, med, newId))
                        .collect(Collectors.toList()))
                .build();


        medRecords.getMedRecords().add(newMedRecord);


        try {
            marshaller.marshal(medRecords, Files.newOutputStream(xmlFile));
        } catch (JAXBException | IOException e) {
            throw new RuntimeException("Error saving med record", e);
        }

        return newId;
    }


    @Override
    public void delete(int medRecordId) {
        MedRecords medRecords;

        try {
            medRecords = (MedRecords) unmarshaller.unmarshal(Files.newInputStream(xmlFile));
        } catch (JAXBException | IOException e) {
            throw new RuntimeException("Error loading existing med records", e);
        }

        List<MedRecord> updatedRecords = medRecords.getMedRecords().stream()
                .filter(medRecord -> medRecord.getId() != medRecordId)
                .collect(Collectors.toList());

        medRecords.setMedRecords(updatedRecords);

        try {
            marshaller.marshal(medRecords, Files.newOutputStream(xmlFile));
        } catch (JAXBException | IOException e) {
            throw new RuntimeException("Error saving med records after deletion", e);
        }
    }

    @Override
    public void updateMedRecord(MedRecordUI medRecordUI) {
        MedRecords medRecords;

        try {
            medRecords = (MedRecords) unmarshaller.unmarshal(Files.newInputStream(xmlFile));
        } catch (JAXBException | IOException e) {
            throw new RuntimeException("Error loading existing med records", e);
        }

        MedRecord existingMedRecord = medRecords.getMedRecords().stream()
                .filter(medRecord -> medRecord.getId() == medRecordUI.getId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("MedRecord not found for ID: " + medRecordUI.getId()));

        existingMedRecord.setIdDoctor(medRecordUI.getIdDoctor());
        existingMedRecord.setDiagnosis(medRecordUI.getDescription());
        existingMedRecord.setDate(medRecordUI.getDate());
        existingMedRecord.setIdPatient(medRecordUI.getIdPatient());

        existingMedRecord.setMedications(medRecordUI.getMedications().stream()
                .map(med -> new Medication(0, med, existingMedRecord.getId()))
                .collect(Collectors.toList()));


        try {
            marshaller.marshal(medRecords, Files.newOutputStream(xmlFile));
        } catch (JAXBException | IOException e) {
            throw new RuntimeException("Error saving updated med record", e);
        }
    }


}
