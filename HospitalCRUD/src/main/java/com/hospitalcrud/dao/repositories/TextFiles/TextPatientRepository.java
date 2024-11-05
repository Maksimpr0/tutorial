package com.hospitalcrud.dao.repositories.TextFiles;

import com.hospitalcrud.config.Configuration;
import com.hospitalcrud.dao.model.Patient;
import com.hospitalcrud.dao.repositories.PatientRepository;
import com.hospitalcrud.dao.mappers.files.PatientRowMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Repository
@Profile("no")
public class TextPatientRepository implements PatientRepository {

    PatientRowMapper patientRowMapper = new PatientRowMapper();

    @Override
    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        Path file = Paths.get(Configuration.getInstance().getProperty("pathPatients"));

        try {
            List<String> lines = readLinesFromFile(file);
            for (String line : lines) {
                patients.add(patientRowMapper.mapRow(line));
            }
        } catch (IOException e) {
            log.error("Error reading patients from file", e);
        }

        return patients;
    }

    @Override
    public int add(Patient patient) {
        Path file = Paths.get(Configuration.getInstance().getProperty("pathPatients"));
        List<String> lines;

        try {
            lines = readLinesFromFile(file);
            patient.setId(lines.size() + 2);
            String add = patientRowMapper.mapUnRow(patient);
            lines.add(add);
            writeLinesToFile(file, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return patient.getId();
    }

    @Override
    public void delete(int patientId, boolean confirm) {
        Path file = Paths.get(Configuration.getInstance().getProperty("pathPatients"));
        List<String> lines;

        try {
            lines = readLinesFromFile(file);
            lines.removeIf(line -> patientRowMapper.mapRow(line).getId() == patientId);
            writeLinesToFile(file, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Patient patient) {
        Path file = Paths.get(Configuration.getInstance().getProperty("pathPatients"));
        List<String> lines;

        try {
            lines = readLinesFromFile(file);
            for (int i = 0; i < lines.size(); i++) {
                Patient currentPatient = patientRowMapper.mapRow(lines.get(i));
                if (currentPatient.getId() == patient.getId()) {
                    lines.set(i, patientRowMapper.mapUnRow(patient));
                    break;
                }
            }
            writeLinesToFile(file, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> readLinesFromFile(Path file) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private void writeLinesToFile(Path file, List<String> lines) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}

