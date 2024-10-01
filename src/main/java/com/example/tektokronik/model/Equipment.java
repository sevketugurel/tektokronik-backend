package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipmentId;

    @Column(nullable = false, length = 50)
    private String equipmentType; // 'kepçe', 'itfaiye aracı', 'ambulans', 'kurtarma ekipmanı'

    @Column(nullable = false, length = 15)
    private String status = "mevcut"; // 'mevcut', 'kullanımda', 'bakımda', 'arıza'

    @ManyToOne
    @JoinColumn(name = "team_id")
    private EmergencyTeam team;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private LocalDateTime lastMaintenanceDate;

    private Integer capacity;


    @OneToMany(mappedBy = "equipment")
    private List<ReportEquipment> reportEquipments;


}