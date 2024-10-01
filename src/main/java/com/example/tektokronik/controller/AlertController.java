package com.example.tektokronik.controller;

import com.example.tektokronik.model.Alert;
import com.example.tektokronik.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @PostMapping
    public ResponseEntity<Alert> createAlert(@Valid @RequestBody Alert alert) {
        Alert createdAlert = alertService.createAlert(alert);
        return new ResponseEntity<>(createdAlert, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alert> getAlertById(@PathVariable Integer id) {
        return alertService.getAlertById(id)
                .map(alert -> new ResponseEntity<>(alert, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Alert> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alert> updateAlert(@PathVariable Integer id, @Valid @RequestBody Alert alertDetails) {
        Alert updatedAlert = alertService.updateAlert(id, alertDetails);
        return new ResponseEntity<>(updatedAlert, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Integer id) {
        alertService.deleteAlert(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
