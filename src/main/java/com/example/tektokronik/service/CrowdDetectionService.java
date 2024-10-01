package com.example.tektokronik.service;

import com.example.tektokronik.model.CrowdDetection;
import com.example.tektokronik.repository.CrowdDetectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrowdDetectionService {

    @Autowired
    private CrowdDetectionRepository crowdDetectionRepository;

    public CrowdDetection createCrowdDetection(CrowdDetection detection) {
        return crowdDetectionRepository.save(detection);
    }

    public Optional<CrowdDetection> getCrowdDetectionById(Integer id) {
        return crowdDetectionRepository.findById(id);
    }

    public List<CrowdDetection> getAllCrowdDetections() {
        return crowdDetectionRepository.findAll();
    }

    public CrowdDetection updateCrowdDetection(Integer id, CrowdDetection detectionDetails) {
        return crowdDetectionRepository.findById(id)
                .map(detection -> {
                    detection.setEstimatedCount(detectionDetails.getEstimatedCount());
                    detection.setLocation(detectionDetails.getLocation());
                    detection.setImage(detectionDetails.getImage());
                    return crowdDetectionRepository.save(detection);
                })
                .orElseThrow(() -> new RuntimeException("Crowd detection not found with id " + id));
    }

    public void deleteCrowdDetection(Integer id) {
        crowdDetectionRepository.deleteById(id);
    }
}
