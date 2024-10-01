package com.example.tektokronik.repository;

import com.example.tektokronik.model.DamageReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageReportRepository extends JpaRepository<DamageReport, Integer> {
}
