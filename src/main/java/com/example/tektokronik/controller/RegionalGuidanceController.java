package com.example.tektokronik.controller;

import com.example.tektokronik.model.RegionalGuidance;
import com.example.tektokronik.service.RegionalGuidanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/regional-guidances")
public class RegionalGuidanceController {

    @Autowired
    private RegionalGuidanceService regionalGuidanceService;

    @PostMapping
    public ResponseEntity<RegionalGuidance> createRegionalGuidance(@Valid @RequestBody RegionalGuidance guidance) {
        RegionalGuidance createdGuidance = regionalGuidanceService.createRegionalGuidance(guidance);
        return new ResponseEntity<>(createdGuidance, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionalGuidance> getRegionalGuidanceById(@PathVariable Integer id) {
        return regionalGuidanceService.getRegionalGuidanceById(id)
                .map(guidance -> new ResponseEntity<>(guidance, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<RegionalGuidance> getAllRegionalGuidances() {
        return regionalGuidanceService.getAllRegionalGuidances();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionalGuidance> updateRegionalGuidance(@PathVariable Integer id, @Valid @RequestBody RegionalGuidance guidanceDetails) {
        RegionalGuidance updatedGuidance = regionalGuidanceService.updateRegionalGuidance(id, guidanceDetails);
        return new ResponseEntity<>(updatedGuidance, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegionalGuidance(@PathVariable Integer id) {
        regionalGuidanceService.deleteRegionalGuidance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
