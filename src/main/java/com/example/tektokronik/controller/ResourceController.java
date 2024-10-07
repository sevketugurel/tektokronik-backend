package com.example.tektokronik.controller;

import com.example.tektokronik.model.Resource;
import com.example.tektokronik.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = "http://localhost:5173")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity<Resource> createResource(@Valid @RequestBody Resource resource) {
        Resource createdResource = resourceService.createResource(resource);
        return new ResponseEntity<>(createdResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Integer id) {
        return resourceService.getResourceById(id)
                .map(resource -> new ResponseEntity<>(resource, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Integer id, @Valid @RequestBody Resource resourceDetails) {
        Resource updatedResource = resourceService.updateResource(id, resourceDetails);
        return new ResponseEntity<>(updatedResource, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Integer id) {
        resourceService.deleteResource(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
