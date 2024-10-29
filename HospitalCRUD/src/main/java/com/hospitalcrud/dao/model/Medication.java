package com.hospitalcrud.dao.model;

import jakarta.xml.bind.annotation.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Medication {

    @XmlTransient
    private int id;
    @XmlValue
    private String medicationName;
    @XmlTransient
    private int medRecordId;
}
