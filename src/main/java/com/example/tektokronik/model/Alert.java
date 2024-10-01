package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alertId;

    @Column(nullable = false, length = 20)
    private String alertType; // 'hasar', 'insan_yogunlugu'

    @ManyToOne
    @JoinColumn(name = "damage_report_id")
    @JsonBackReference // Döngüleri önlemek için back reference
    private DamageReport damageReport;

    @ManyToOne
    @JoinColumn(name = "crowd_detection_id")
    @JsonBackReference // Döngüyü önlemek için
    private CrowdDetection crowdDetection;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private EmergencyTeam team;

    @Column(nullable = false, length = 15)
    private String status = "yeni"; // 'yeni', 'görüldü', 'tamamlandı'

    @Column(nullable = false)
    private LocalDateTime alertDate = LocalDateTime.now();

}
