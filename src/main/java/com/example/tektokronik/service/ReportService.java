package com.example.tektokronik.service;

import com.example.tektokronik.model.Report;
import com.example.tektokronik.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Optional<Report> getReportById(Integer id) {
        return reportRepository.findById(id);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report updateReport(Integer id, Report reportDetails) {
        return reportRepository.findById(id)
                .map(report -> {
                    report.setLocation(reportDetails.getLocation());
                    report.setEstimatedPeople(reportDetails.getEstimatedPeople());
                    report.setBuildingStatus(reportDetails.getBuildingStatus());
                    report.setReportStatus(reportDetails.getReportStatus());
                    report.setImage(reportDetails.getImage());
                    report.setTeam(reportDetails.getTeam());
                    return reportRepository.save(report);
                })
                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));
    }

    public void deleteReport(Integer id) {
        reportRepository.deleteById(id);
    }
}
