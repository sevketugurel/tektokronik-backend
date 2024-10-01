package com.example.tektokronik.model;

import com.example.tektokronik.model.CrowdDetection;
import com.example.tektokronik.model.DamageReport;
import com.example.tektokronik.model.Report;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "images")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    @Column(nullable = false, length = 10)
    private String imageType; // 'uydu', 'drone'

    @Column(nullable = false)
    private LocalDateTime captureDate;

    @Column(nullable = false, length = 255)
    private String filePath;

    @Column(nullable = false, precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(nullable = false, precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(nullable = false)
    private Boolean processed = false;

    @OneToMany(mappedBy = "image")
    @JsonBackReference // Serileştirilecek taraf
    private List<DamageReport> damageReports;

    @ManyToOne
    @JoinColumn(name = "crowd_detection_id")
    @JsonBackReference // Sonsuz döngüyü önlemek için back reference kullanıyoruz
    private CrowdDetection crowdDetection;

    @OneToMany(mappedBy = "image")
    @JsonBackReference
    private List<Report> reports;

}
