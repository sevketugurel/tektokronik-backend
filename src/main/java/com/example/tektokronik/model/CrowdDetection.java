package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "crowd_detections")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "crowdDetectionId")
public class CrowdDetection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer crowdDetectionId;

    @ManyToOne
    @JoinColumn(name = "image_id", nullable = false)
    //@JsonBackReference
    private Image image;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    //@JsonBackReference
    private Location location;

    @Column(nullable = false)
    private Integer estimatedCount;

    @Column(nullable = false)
    private LocalDateTime detectionDate = LocalDateTime.now();

    @OneToMany(mappedBy = "crowdDetection")
    @JsonBackReference
    private List<Alert> alerts;

    @OneToMany(mappedBy = "crowdDetection")
    private List<RegionalGuidance> regionalGuidances;
}
