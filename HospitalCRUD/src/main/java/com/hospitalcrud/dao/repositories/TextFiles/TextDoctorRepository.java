package com.hospitalcrud.dao.repositories.TextFiles;

import com.hospitalcrud.config.Configuration;
import com.hospitalcrud.dao.model.Doctor;
import com.hospitalcrud.dao.repositories.DoctorRepository;
import com.hospitalcrud.domain.model.DoctorUI;
import com.hospitalcrud.mappers.DoctorRowMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Repository
@Profile("enDesarrollo")
public class TextDoctorRepository implements DoctorRepository {

    DoctorRowMapper doctorRowMapper = new DoctorRowMapper();

    @Override
    public List<DoctorUI> getAll() {
        List<DoctorUI> doctorUIS = new ArrayList<>();
        Path file = Paths.get(Configuration.getInstance().getProperty("pathDoctors"));

        List<String> fileList;

        try {

            fileList = Files.readAllLines(file);

            for (String line : fileList) {
                DoctorUI doctor = doctorRowMapper.mapRow(line);
                doctorUIS.add(doctor);
            }


        } catch (IOException io) {
            System.err.println(io);
        }
        return doctorUIS;
    }
}
