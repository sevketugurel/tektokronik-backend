package com.example.tektokronik.repository;

import com.example.tektokronik.model.AssemblyPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssemblyPointRepository extends JpaRepository<AssemblyPoint, Integer> {
}
