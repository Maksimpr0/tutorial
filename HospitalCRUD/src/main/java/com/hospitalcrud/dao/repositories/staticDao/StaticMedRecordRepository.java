package com.hospitalcrud.dao.repositories.staticDao;

import com.hospitalcrud.dao.model.MedRecord;
import com.hospitalcrud.dao.model.Medication;
import com.hospitalcrud.dao.repositories.MedRecordRepository;
import com.hospitalcrud.domain.model.MedRecordUI;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("enDesarrollo")
public class StaticMedRecordRepository implements MedRecordRepository {

    private  List<MedRecord> medRecords = new ArrayList<>();
    private List<Medication> medications = new ArrayList<>();
    public List<MedRecord> getAll() {
        medications = new ArrayList<>();
        medRecords = new ArrayList<>();
        medications.add(new Medication(1,"paracetamol",1));
        medRecords.add(new MedRecord(1,1,1,"diarrea",LocalDate.now(),medications));
        return medRecords;
    }

    @Override
    public List<MedRecord> getAll(int patientId) {
        return null;
    }

    public int addMedrecord(MedRecordUI medRecordUI){
        System.out.println("addMR");
        return 4;
    }

    public void delete (int medRecordId){
        System.out.println("deleteMR");
    }
    public void updateMedRecord(MedRecordUI medRecordUI){
        System.out.println("updateMR");
    }

}
