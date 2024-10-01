package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;

    @Column(nullable = false, length = 50)
    private String type; // 'gıda', 'battaniye', 'ilaç'

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

}
