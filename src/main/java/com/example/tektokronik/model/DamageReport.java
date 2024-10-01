package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "damage_reports")
public class DamageReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @ManyToOne
    @JoinColumn(name = "image_id", nullable = false)
    @JsonManagedReference
    private Image image;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    @JsonManagedReference
    private Location location;

    @Column(nullable = false, length = 20)
    private String damageType; // 'bina', 'yol', 'köprü', 'diğer'

    @Column(nullable = false, length = 10)
    private String severity; // 'hafif', 'orta', 'ağır', 'yıkılmış'

    @Column(nullable = false)
    private LocalDateTime reportDate = LocalDateTime.now();

    @OneToMany(mappedBy = "damageReport")
    @JsonManagedReference
    private List<Alert> alerts;


}
