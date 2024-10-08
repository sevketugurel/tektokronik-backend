package com.example.tektokronik.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "coordinations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coordination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordination_id")
    private Long coordinationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private EmergencyTeam team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assembly_point_id", nullable = false)
    private AssemblyPoint assemblyPoint;

    @Column(name = "resources_assigned", columnDefinition = "TEXT")
    private String resourcesAssigned; // JSON formatında

    @Column(name = "equipments_assigned", columnDefinition = "TEXT")
    private String equipmentsAssigned; // JSON formatında

    @Column(name = "coordination_date", nullable = false)
    private LocalDateTime coordinationDate;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
