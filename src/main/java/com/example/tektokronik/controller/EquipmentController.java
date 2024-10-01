package com.example.tektokronik.controller;

import com.example.tektokronik.model.Equipment;
import com.example.tektokronik.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@Valid @RequestBody Equipment equipment) {
        Equipment createdEquipment = equipmentService.createEquipment(equipment);
        return new ResponseEntity<>(createdEquipment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Integer id) {
        return equipmentService.getEquipmentById(id)
                .map(equipment -> new ResponseEntity<>(equipment, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Equipment> getAllEquipments() {
        return equipmentService.getAllEquipments();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Integer id, @Valid @RequestBody Equipment equipmentDetails) {
        Equipment updatedEquipment = equipmentService.updateEquipment(id, equipmentDetails);
        return new ResponseEntity<>(updatedEquipment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer id) {
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
