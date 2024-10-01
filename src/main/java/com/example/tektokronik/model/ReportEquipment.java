package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "report_equipment")
public class ReportEquipment {

    @EmbeddedId
    private ReportEquipmentId id;

    @ManyToOne
    @MapsId("reportId")
    @JoinColumn(name = "report_id")
    @JsonBackReference // report'un yönetiminde olacak
    private Report report;

    @ManyToOne
    @MapsId("equipmentId")
    @JoinColumn(name = "equipment_id")
    @JsonBackReference // equipment'in yönetiminde olacak
    private Equipment equipment;


}
