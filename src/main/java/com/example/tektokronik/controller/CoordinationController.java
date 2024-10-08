package com.example.tektokronik.controller;

import com.example.tektokronik.exception.ResourceNotFoundException;
import com.example.tektokronik.model.Coordination;
import com.example.tektokronik.service.CoordinationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/coordinations")
@CrossOrigin(origins = "http://localhost:5173")
public class CoordinationController {

    private final CoordinationService coordinationService;

    @Autowired
    public CoordinationController(CoordinationService coordinationService) {
        this.coordinationService = coordinationService;
    }

    // Tüm koordinasyonları getirme
    @GetMapping
    public List<Coordination> getAllCoordinations() {
        return coordinationService.getAllCoordinations();
    }

    // ID'ye göre koordinasyon bulma
    @GetMapping("/{id}")
    public ResponseEntity<Coordination> getCoordinationById(@PathVariable(value = "id") Long coordinationId)
            throws ResourceNotFoundException {
        Coordination coordination = coordinationService.getCoordinationById(coordinationId)
                .orElseThrow(() -> new ResourceNotFoundException("Coordination not found for this id :: " + coordinationId));
        return ResponseEntity.ok().body(coordination);
    }

    // Yeni koordinasyon oluşturma
    @PostMapping
    public Coordination createCoordination(@Valid @RequestBody Coordination coordination) {
        return coordinationService.createCoordination(coordination);
    }

    // Mevcut koordinasyonu güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Coordination> updateCoordination(
            @PathVariable(value = "id") Long coordinationId,
            @Valid @RequestBody Coordination coordinationDetails) throws ResourceNotFoundException {
        Coordination updatedCoordination = coordinationService.updateCoordination(coordinationId, coordinationDetails);
        return ResponseEntity.ok(updatedCoordination);
    }

    // Koordinasyonu silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoordination(@PathVariable(value = "id") Long coordinationId)
            throws ResourceNotFoundException {
        coordinationService.deleteCoordination(coordinationId);
        return ResponseEntity.noContent().build();
    }

    // Belirli bir rapora ait koordinasyonları getirme
    @GetMapping("/report/{reportId}")
    public List<Coordination> getCoordinationsByReportId(@PathVariable Long reportId) {
        return coordinationService.getCoordinationsByReportId(reportId);
    }

    // Belirli bir ekibe ait koordinasyonları getirme
    @GetMapping("/team/{teamId}")
    public List<Coordination> getCoordinationsByTeamId(@PathVariable Long teamId) {
        return coordinationService.getCoordinationsByTeamId(teamId);
    }

    // Belirli bir toplanma alanına ait koordinasyonları getirme
    @GetMapping("/assembly-point/{assemblyPointId}")
    public List<Coordination> getCoordinationsByAssemblyPointId(@PathVariable Long assemblyPointId) {
        return coordinationService.getCoordinationsByAssemblyPointId(assemblyPointId);
    }
}
