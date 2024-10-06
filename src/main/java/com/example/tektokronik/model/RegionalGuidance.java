package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "regional_guidance")
public class RegionalGuidance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guidanceId;

    @ManyToOne
    @JoinColumn(name = "crowd_detection_id", nullable = false)
    @JsonManagedReference // Bu tarafı yönetici olarak işaretliyoruz
    private CrowdDetection crowdDetection;

    @ManyToOne
    @JoinColumn(name = "assembly_id", nullable = false)
    @JsonManagedReference // Sonsuz döngüyü önlemek için bu taraf geri referans olarak kalıyor
    private AssemblyPoint assemblyPoint;

    @Column(nullable = false)
    private LocalDateTime assignedAt = LocalDateTime.now();

    @Column(nullable = false, length = 15)
    private String status = "beklemede"; // 'beklemede', 'uygulandı', 'iptal edildi'
}
