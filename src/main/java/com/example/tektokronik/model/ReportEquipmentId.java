package com.example.tektokronik.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReportEquipmentId implements Serializable {

    private Integer reportId;
    private Integer equipmentId;


}