package com.example.tektokronik.service;

import com.example.tektokronik.model.Equipment;
import com.example.tektokronik.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Optional<Equipment> getEquipmentById(Integer id) {
        return equipmentRepository.findById(id);
    }

    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    public Equipment updateEquipment(Integer id, Equipment equipmentDetails) {
        return equipmentRepository.findById(id)
                .map(equipment -> {
                    equipment.setEquipmentType(equipmentDetails.getEquipmentType());
                    equipment.setStatus(equipmentDetails.getStatus());
                    equipment.setLastMaintenanceDate(equipmentDetails.getLastMaintenanceDate());
                    equipment.setTeam(equipmentDetails.getTeam());
                    equipment.setLocation(equipmentDetails.getLocation());
                    return equipmentRepository.save(equipment);
                })
                .orElseThrow(() -> new RuntimeException("Equipment not found with id " + id));
    }

    public void deleteEquipment(Integer id) {
        equipmentRepository.deleteById(id);
    }
}
