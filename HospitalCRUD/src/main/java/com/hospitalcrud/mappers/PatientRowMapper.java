package com.hospitalcrud.mappers;

import com.hospitalcrud.dao.model.Patient;

import java.time.LocalDate;

public class PatientRowMapper {

    public Patient mapRow(String e) {
        String palabras[];
        String fecha[];
        String fechabuena="";
        palabras = e.split(";");
        if (palabras[2].contains("/")){
            fecha = palabras[2].split("/");
            fechabuena = fecha[2] + "-" + fecha[1] + "-" + fecha[0];
        }else fechabuena = palabras[2];


        return new Patient(Integer.parseInt(palabras[0]), palabras[1], LocalDate.parse(fechabuena), palabras[3]);
    }

    public String mapUnRow(Patient p){
        String s = p.getId()+";"+p.getName()+";"+p.getBirthDate()+";"+p.getPhone();
        return s;
    }

}
