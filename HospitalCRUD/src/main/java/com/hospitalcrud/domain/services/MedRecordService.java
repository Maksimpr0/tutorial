 package com.hospitalcrud.domain.services;

import com.hospitalcrud.dao.model.MedRecord;
import com.hospitalcrud.dao.repositories.XmlFiles.XmlMedRecordRepository;
import com.hospitalcrud.domain.model.MedRecordUI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedRecordService {

   private final XmlMedRecordRepository xmlMedRecordRepository;

    public MedRecordService(XmlMedRecordRepository xmlMedRecordRepository) {
        this.xmlMedRecordRepository = xmlMedRecordRepository;
    }


    public List<MedRecordUI> getAll(int idPatient){
       List<MedRecord> medrecords = xmlMedRecordRepository.getAll(idPatient);
       List<MedRecordUI> medRecordUI = new ArrayList<>();


       medrecords.forEach(medRecord -> {
           List<String> medicationsName = new ArrayList<>();

           medRecord.getMedications().forEach(medication -> {
               medicationsName.add(medication.getMedicationName());
           });

           medRecordUI.add(new MedRecordUI(medRecord.getId(),medRecord.getDiagnosis(),
                   medRecord.getDate(),medRecord.getIdPatient(),medRecord.getIdDoctor(),medicationsName));

       });


        return medRecordUI;
    }

    public int add(MedRecordUI medRecordUI) {
        xmlMedRecordRepository.addMedrecord(medRecordUI);
        return 1;
    }
    public void delete(int id){
        xmlMedRecordRepository.delete(id);
    }
    public void update(MedRecordUI medRecordUI){
        xmlMedRecordRepository.updateMedRecord(medRecordUI);
    }

}
