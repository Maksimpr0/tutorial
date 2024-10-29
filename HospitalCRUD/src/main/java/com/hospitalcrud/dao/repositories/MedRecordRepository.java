package com.hospitalcrud.dao.repositories;

import com.hospitalcrud.dao.model.MedRecord;
import com.hospitalcrud.domain.model.MedRecordUI;

import java.util.List;

public interface MedRecordRepository {
    List<MedRecord> getAll(int patientId);
    int addMedrecord(MedRecordUI medRecordUI);
    void delete (int medRecordId);
    void updateMedRecord(MedRecordUI medRecordUI);

}
