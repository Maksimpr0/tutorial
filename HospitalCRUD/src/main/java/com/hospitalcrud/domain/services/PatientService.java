package com.hospitalcrud.domain.services;

import com.hospitalcrud.dao.model.Patient;
import com.hospitalcrud.dao.repositories.PatientRepository;
import com.hospitalcrud.dao.repositories.TextFiles.TextPatientRepository;
import com.hospitalcrud.dao.repositories.staticDao.StaticPatientRepository;
import com.hospitalcrud.domain.model.PatientUI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PatientService {

    private int num = 3;
    private final TextPatientRepository textPatientRepository;

    public PatientService(TextPatientRepository textPatientRepository) {
        this.textPatientRepository = textPatientRepository;
    }


    public List<PatientUI> getPatients(){
        List<Patient> patient = textPatientRepository.getAll();
        List<PatientUI> patientsUI = new ArrayList<>();
        //TODO Transform Patient to PatientUI
        patient.forEach(patient1 -> {patientsUI.add(new PatientUI(patient1.getId(),patient1.getName(),
                patient1.getBirthDate(),patient1.getPhone(),0,null,null));});

        return patientsUI;
    }

    public int addPatient(PatientUI patientUI) {
        Patient patient = new Patient(patientUI.getId(),patientUI.getName(),patientUI.getBirthDate(),patientUI.getPhone());
        textPatientRepository.add(patient);
        return textPatientRepository.getAll().size()+1;
    }
    public void delete (int patientId,boolean confirm){
        textPatientRepository.delete(patientId,confirm);
    }

    public void updatePatient(PatientUI patientUI){
        Patient patient = new Patient(patientUI.getId(),patientUI.getName(),patientUI.getBirthDate(),patientUI.getPhone());
        textPatientRepository.update(patient);
    }
}
