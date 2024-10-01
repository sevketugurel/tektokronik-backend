package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private EmergencyTeam team;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    private Integer estimatedPeople;

    @Column(length = 20)
    private String buildingStatus; // 'sağlam', 'hasarlı', 'yıkılmış'

    @Column(nullable = false, length = 20)
    private String reportStatus = "beklemede"; // 'beklemede', 'işlemde', 'tamamlandı', 'iptal edildi'

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "report")
    private List<ReportEquipment> reportEquipments;

}