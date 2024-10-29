package com.hospitalcrud.dao.repositories.staticDao;

import com.hospitalcrud.dao.repositories.DoctorRepository;
import com.hospitalcrud.domain.model.DoctorUI;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


@Repository
@Profile("enDesarrollo")
public class StaticDoctorRepository implements DoctorRepository {
    private List<DoctorUI> doctorList ;
    public List<DoctorUI> getAll(){
        doctorList = new ArrayList<>();
        doctorList.add(new DoctorUI(1,"Diegov"));
        doctorList.add(new DoctorUI(2,"Whalterov"));
        doctorList.add(new DoctorUI(3,"Felixov"));
        return doctorList;
    }
}
