package com.hospitalcrud.dao.model;

import com.hospitalcrud.dao.mappers.files.LocalDateAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@XmlRootElement(name="medRecord")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedRecord {
    private int id;
    private int idPatient;
    @XmlElement(name="doctor")
    private int idDoctor;
    private String diagnosis;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate date;
    @XmlElementWrapper(name="medications")
    @XmlElement(name="medication")
    private List<Medication> medications;
}
