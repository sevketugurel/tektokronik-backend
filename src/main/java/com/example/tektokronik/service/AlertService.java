package com.example.tektokronik.service;

import com.example.tektokronik.model.Alert;
import com.example.tektokronik.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public Alert createAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    public Optional<Alert> getAlertById(Integer id) {
        return alertRepository.findById(id);
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public Alert updateAlert(Integer id, Alert alertDetails) {
        return alertRepository.findById(id)
                .map(alert -> {
                    alert.setAlertType(alertDetails.getAlertType());
                    alert.setDamageReport(alertDetails.getDamageReport());
                    alert.setCrowdDetection(alertDetails.getCrowdDetection());
                    alert.setStatus(alertDetails.getStatus());
                    alert.setTeam(alertDetails.getTeam());
                    return alertRepository.save(alert);
                })
                .orElseThrow(() -> new RuntimeException("Alert not found with id " + id));
    }

    public void deleteAlert(Integer id) {
        alertRepository.deleteById(id);
    }
}
