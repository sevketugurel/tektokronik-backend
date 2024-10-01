package com.example.tektokronik.service;

import com.example.tektokronik.model.Resource;
import com.example.tektokronik.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Optional<Resource> getResourceById(Integer id) {
        return resourceRepository.findById(id);
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource updateResource(Integer id, Resource resourceDetails) {
        return resourceRepository.findById(id)
                .map(resource -> {
                    resource.setType(resourceDetails.getType());
                    resource.setQuantity(resourceDetails.getQuantity());
                    resource.setLocation(resourceDetails.getLocation());
                    return resourceRepository.save(resource);
                })
                .orElseThrow(() -> new RuntimeException("Resource not found with id " + id));
    }

    public void deleteResource(Integer id) {
        resourceRepository.deleteById(id);
    }
}
