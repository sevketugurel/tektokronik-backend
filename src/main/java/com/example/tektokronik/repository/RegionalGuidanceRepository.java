package com.example.tektokronik.repository;

import com.example.tektokronik.model.RegionalGuidance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionalGuidanceRepository extends JpaRepository<RegionalGuidance, Integer> {
}
