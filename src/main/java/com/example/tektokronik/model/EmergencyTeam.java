package com.example.tektokronik.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "emergency_teams")
public class EmergencyTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;

    @Column(nullable = false, length = 100)
    private String teamName;

    @Column(length = 255)
    private String contactDetails;

    @Column(length = 100)
    private String assignedRegion;

    @Column
    private Integer capacity;

    @Column(nullable = false, length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "current_location_id")
    private Location currentLocation; // Bir ekip bir lokasyonda olabilir

    @OneToMany(mappedBy = "team")
    @JsonIgnoreProperties("team")  // Sonsuz döngüyü engellemek için eklenen satır
    private List<User> users;
}
