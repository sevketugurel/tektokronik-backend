package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "assembly_points")
public class AssemblyPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assemblyId;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    @JsonManagedReference
    private Location location;

    private Integer capacity;

    private Integer estimatedOccupancy = 0;

    @Column(nullable = false, length = 10)
    private String status = "açık";

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "assemblyPoint")
    @JsonBackReference
    private List<RegionalGuidance> regionalGuidances;
}
