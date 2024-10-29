package com.hospitalcrud.dao.repositories;

import com.hospitalcrud.dao.model.Patient;
import com.hospitalcrud.domain.model.PatientUI;

import java.util.List;

public interface PatientRepository {
    List<Patient> getAll();
    int add(Patient patient);
    void delete (int patientId,boolean confirm);
    void update(Patient patient);
}
