package com.example.tektokronik.repository;

import com.example.tektokronik.model.CrowdDetection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrowdDetectionRepository extends JpaRepository<CrowdDetection, Integer> {
}
