package com.example.tektokronik.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    @Column(nullable = false, precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(nullable = false, precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(length = 255)
    private String address;

    @Column(length = 100)
    private String region;

    @Column(nullable = false, length = 20)
    private String locationType = "genel"; // 'hasar', 'insan_yogunlugu', 'toplanma_alani', 'kaynak', 'genel'

}
