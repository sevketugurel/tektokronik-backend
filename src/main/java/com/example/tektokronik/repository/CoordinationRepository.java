package com.example.tektokronik.repository;

import com.example.tektokronik.model.Coordination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoordinationRepository extends JpaRepository<Coordination, Long> {

    // Belirli bir rapora ait koordinasyonları bulmak için
    List<Coordination> findByReportReportId(Long reportId);

    // Belirli bir ekibe ait koordinasyonları bulmak için
    List<Coordination> findByTeamTeamId(Long teamId);

    // Belirli bir toplanma alanına ait koordinasyonları bulmak için
    List<Coordination> findByAssemblyPointAssemblyId(Long assemblyPointId);
}
