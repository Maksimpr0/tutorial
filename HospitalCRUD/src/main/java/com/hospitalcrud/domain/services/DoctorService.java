package com.hospitalcrud.domain.services;

import com.hospitalcrud.dao.repositories.DoctorRepository;
import com.hospitalcrud.dao.repositories.TextFiles.TextDoctorRepository;
import com.hospitalcrud.dao.repositories.staticDao.StaticDoctorRepository;
import com.hospitalcrud.domain.model.DoctorUI;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorService  {
    private TextDoctorRepository textDoctorRepository;

    public DoctorService(TextDoctorRepository textDoctorRepository) {
        this.textDoctorRepository = textDoctorRepository;
    }

    public List<DoctorUI> findAll(){
        return textDoctorRepository.getAll();
    }
}
