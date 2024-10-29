package com.hospitalcrud.dao.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MedRecords {

    @XmlElement(name = "medRecord")
    List<MedRecord> medRecords = new ArrayList<>();


    public MedRecords() {
    }

    public MedRecords(List<MedRecord> medRecords){
        this.medRecords = medRecords;
    }

}
