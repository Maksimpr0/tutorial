package com.hospitalcrud.mappers;

import com.hospitalcrud.domain.model.DoctorUI;

public class DoctorRowMapper {
    public DoctorUI mapRow(String e) {
        String doctor [] = e.split(";");

        return new DoctorUI(Integer.parseInt(doctor[0]),doctor[1]);
    }
}
