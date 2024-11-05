package com.hospitalcrud.dao.repositories.staticDao;

import com.hospitalcrud.dao.model.Patient;
import com.hospitalcrud.dao.repositories.PatientRepository;
import com.hospitalcrud.domain.model.PatientUI;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("null")
public class StaticPatientRepository implements PatientRepository {

    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1,"John Smith" , LocalDate.of(2003,05,23),"333-222-111"));
        patients.add(new Patient(2,"FDiego Smith" , LocalDate.of(2003,05,23),"333-222-111"));
        patients.add(new Patient(3,"Maksim Smith" , LocalDate.of(2003,05,23),"333-222-111"));

        return patients;
    }
    public int add(Patient patient){
        System.out.println("add");
        return 4;
    }

    public void delete (int patientId,boolean confirm){
        System.out.println("delete");
    }
    public void update(Patient patient){
        System.out.println("update");
    }

}
