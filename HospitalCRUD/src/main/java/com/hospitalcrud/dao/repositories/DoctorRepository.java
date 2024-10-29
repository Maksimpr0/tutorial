package com.hospitalcrud.dao.repositories;

import com.hospitalcrud.domain.model.DoctorUI;

import java.util.List;

public interface DoctorRepository {
    List<DoctorUI> getAll();
}
