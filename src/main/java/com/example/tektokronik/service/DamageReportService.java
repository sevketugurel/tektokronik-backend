package com.example.tektokronik.service;

import com.example.tektokronik.model.DamageReport;
import com.example.tektokronik.repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DamageReportService {

    @Autowired
    private DamageReportRepository damageReportRepository;

    public DamageReport createDamageReport(DamageReport report) {
        return damageReportRepository.save(report);
    }

    public Optional<DamageReport> getDamageReportById(Integer id) {
        return damageReportRepository.findById(id);
    }

    public List<DamageReport> getAllDamageReports() {
        return damageReportRepository.findAll();
    }

    public DamageReport updateDamageReport(Integer id, DamageReport reportDetails) {
        return damageReportRepository.findById(id)
                .map(report -> {
                    report.setDamageType(reportDetails.getDamageType());
                    report.setSeverity(reportDetails.getSeverity());
                    report.setLocation(reportDetails.getLocation());
                    report.setImage(reportDetails.getImage());
                    return damageReportRepository.save(report);
                })
                .orElseThrow(() -> new RuntimeException("Damage report not found with id " + id));
    }

    public void deleteDamageReport(Integer id) {
        damageReportRepository.deleteById(id);
    }
}
