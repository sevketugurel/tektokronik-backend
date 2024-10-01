package com.example.tektokronik.controller;

import com.example.tektokronik.model.AssemblyPoint;
import com.example.tektokronik.service.AssemblyPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/assembly-points")
public class AssemblyPointController {

    @Autowired
    private AssemblyPointService assemblyPointService;

    @PostMapping
    public ResponseEntity<AssemblyPoint> createAssemblyPoint(@Valid @RequestBody AssemblyPoint point) {
        AssemblyPoint createdPoint = assemblyPointService.createAssemblyPoint(point);
        return new ResponseEntity<>(createdPoint, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssemblyPoint> getAssemblyPointById(@PathVariable Integer id) {
        return assemblyPointService.getAssemblyPointById(id)
                .map(point -> new ResponseEntity<>(point, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<AssemblyPoint> getAllAssemblyPoints() {
        return assemblyPointService.getAllAssemblyPoints();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssemblyPoint> updateAssemblyPoint(@PathVariable Integer id, @Valid @RequestBody AssemblyPoint pointDetails) {
        AssemblyPoint updatedPoint = assemblyPointService.updateAssemblyPoint(id, pointDetails);
        return new ResponseEntity<>(updatedPoint, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssemblyPoint(@PathVariable Integer id) {
        assemblyPointService.deleteAssemblyPoint(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
