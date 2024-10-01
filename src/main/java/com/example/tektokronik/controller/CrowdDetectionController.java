package com.example.tektokronik.controller;

import com.example.tektokronik.model.CrowdDetection;
import com.example.tektokronik.service.CrowdDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/crowd-detections")
public class CrowdDetectionController {

    @Autowired
    private CrowdDetectionService crowdDetectionService;

    @PostMapping
    public ResponseEntity<CrowdDetection> createCrowdDetection(@Valid @RequestBody CrowdDetection detection) {
        CrowdDetection createdDetection = crowdDetectionService.createCrowdDetection(detection);
        return new ResponseEntity<>(createdDetection, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrowdDetection> getCrowdDetectionById(@PathVariable Integer id) {
        return crowdDetectionService.getCrowdDetectionById(id)
                .map(detection -> new ResponseEntity<>(detection, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<CrowdDetection> getAllCrowdDetections() {
        return crowdDetectionService.getAllCrowdDetections();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrowdDetection> updateCrowdDetection(@PathVariable Integer id, @Valid @RequestBody CrowdDetection detectionDetails) {
        CrowdDetection updatedDetection = crowdDetectionService.updateCrowdDetection(id, detectionDetails);
        return new ResponseEntity<>(updatedDetection, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrowdDetection(@PathVariable Integer id) {
        crowdDetectionService.deleteCrowdDetection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
