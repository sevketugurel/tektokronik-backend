package com.example.tektokronik.service;

import com.example.tektokronik.model.AssemblyPoint;
import com.example.tektokronik.repository.AssemblyPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssemblyPointService {

    @Autowired
    private AssemblyPointRepository assemblyPointRepository;

    public AssemblyPoint createAssemblyPoint(AssemblyPoint point) {
        return assemblyPointRepository.save(point);
    }

    public Optional<AssemblyPoint> getAssemblyPointById(Integer id) {
        return assemblyPointRepository.findById(id);
    }

    public List<AssemblyPoint> getAllAssemblyPoints() {
        return assemblyPointRepository.findAll();
    }

    public AssemblyPoint updateAssemblyPoint(Integer id, AssemblyPoint pointDetails) {
        return assemblyPointRepository.findById(id)
                .map(point -> {
                    point.setName(pointDetails.getName());
                    point.setLocation(pointDetails.getLocation());
                    point.setCapacity(pointDetails.getCapacity());
                    point.setEstimatedOccupancy(pointDetails.getEstimatedOccupancy());
                    point.setStatus(pointDetails.getStatus());
                    return assemblyPointRepository.save(point);
                })
                .orElseThrow(() -> new RuntimeException("Assembly point not found with id " + id));
    }

    public void deleteAssemblyPoint(Integer id) {
        assemblyPointRepository.deleteById(id);
    }
}
