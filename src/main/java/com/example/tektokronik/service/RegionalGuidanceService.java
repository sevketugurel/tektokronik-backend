package com.example.tektokronik.service;

import com.example.tektokronik.model.RegionalGuidance;
import com.example.tektokronik.repository.RegionalGuidanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionalGuidanceService {

    @Autowired
    private RegionalGuidanceRepository regionalGuidanceRepository;

    public RegionalGuidance createRegionalGuidance(RegionalGuidance guidance) {
        return regionalGuidanceRepository.save(guidance);
    }

    public Optional<RegionalGuidance> getRegionalGuidanceById(Integer id) {
        return regionalGuidanceRepository.findById(id);
    }

    public List<RegionalGuidance> getAllRegionalGuidances() {
        return regionalGuidanceRepository.findAll();
    }

    public RegionalGuidance updateRegionalGuidance(Integer id, RegionalGuidance guidanceDetails) {
        return regionalGuidanceRepository.findById(id)
                .map(guidance -> {
                    guidance.setCrowdDetection(guidanceDetails.getCrowdDetection());
                    guidance.setAssemblyPoint(guidanceDetails.getAssemblyPoint());
                    guidance.setStatus(guidanceDetails.getStatus());
                    return regionalGuidanceRepository.save(guidance);
                })
                .orElseThrow(() -> new RuntimeException("Regional guidance not found with id " + id));
    }

    public void deleteRegionalGuidance(Integer id) {
        regionalGuidanceRepository.deleteById(id);
    }
}
