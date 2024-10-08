package com.example.tektokronik.service;

import com.example.tektokronik.exception.ResourceNotFoundException;
import com.example.tektokronik.model.Coordination;
import com.example.tektokronik.repository.CoordinationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CoordinationService {

    private final CoordinationRepository coordinationRepository;

    @Autowired
    public CoordinationService(CoordinationRepository coordinationRepository) {
        this.coordinationRepository = coordinationRepository;
    }

    // Tüm koordinasyonları getirme
    public List<Coordination> getAllCoordinations() {
        return coordinationRepository.findAll();
    }

    // ID'ye göre koordinasyon bulma
    public Optional<Coordination> getCoordinationById(Long id) {
        return coordinationRepository.findById(id);
    }

    // Yeni koordinasyon oluşturma
    public Coordination createCoordination(Coordination coordination) {
        return coordinationRepository.save(coordination);
    }

    // Mevcut koordinasyonu güncelleme
    public Coordination updateCoordination(Long id, Coordination coordinationDetails) {
        Coordination coordination = coordinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coordination not found for this id :: " + id));

        coordination.setReport(coordinationDetails.getReport());
        coordination.setTeam(coordinationDetails.getTeam());
        coordination.setAssemblyPoint(coordinationDetails.getAssemblyPoint());
        coordination.setResourcesAssigned(coordinationDetails.getResourcesAssigned());
        coordination.setEquipmentsAssigned(coordinationDetails.getEquipmentsAssigned());
        coordination.setCoordinationDate(coordinationDetails.getCoordinationDate());
        coordination.setStatus(coordinationDetails.getStatus());
        // createdAt güncellenmemeli, sadece updatedAt

        return coordinationRepository.save(coordination);
    }

    // Koordinasyonu silme
    public void deleteCoordination(Long id) {
        Coordination coordination = coordinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coordination not found for this id :: " + id));
        coordinationRepository.delete(coordination);
    }

    // Belirli bir rapora ait koordinasyonları getirme
    public List<Coordination> getCoordinationsByReportId(Long reportId) {
        return coordinationRepository.findByReportReportId(reportId);
    }

    // Belirli bir ekibe ait koordinasyonları getirme
    public List<Coordination> getCoordinationsByTeamId(Long teamId) {
        return coordinationRepository.findByTeamTeamId(teamId);
    }

    // Belirli bir toplanma alanına ait koordinasyonları getirme
    public List<Coordination> getCoordinationsByAssemblyPointId(Long assemblyPointId) {
        return coordinationRepository.findByAssemblyPointAssemblyId(assemblyPointId);
    }
}
