package com.example.tektokronik.controller;

import com.example.tektokronik.model.DamageReport;
import com.example.tektokronik.service.DamageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/damage-reports")
public class DamageReportController {

    @Autowired
    private DamageReportService damageReportService;

    @PostMapping
    public ResponseEntity<DamageReport> createDamageReport(@Valid @RequestBody DamageReport report) {
        DamageReport createdReport = damageReportService.createDamageReport(report);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DamageReport> getDamageReportById(@PathVariable Integer id) {
        return damageReportService.getDamageReportById(id)
                .map(report -> new ResponseEntity<>(report, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<DamageReport> getAllDamageReports() {
        return damageReportService.getAllDamageReports();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DamageReport> updateDamageReport(@PathVariable Integer id, @Valid @RequestBody DamageReport reportDetails) {
        DamageReport updatedReport = damageReportService.updateDamageReport(id, reportDetails);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDamageReport(@PathVariable Integer id) {
        damageReportService.deleteDamageReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
