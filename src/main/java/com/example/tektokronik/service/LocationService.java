package com.example.tektokronik.service;

import com.example.tektokronik.model.Location;
import com.example.tektokronik.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Optional<Location> getLocationById(Integer id) {
        return locationRepository.findById(id);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location updateLocation(Integer id, Location locationDetails) {
        return locationRepository.findById(id)
                .map(location -> {
                    location.setLatitude(locationDetails.getLatitude());
                    location.setLongitude(locationDetails.getLongitude());
                    location.setAddress(locationDetails.getAddress());
                    location.setRegion(locationDetails.getRegion());
                    location.setLocationType(locationDetails.getLocationType());
                    return locationRepository.save(location);
                })
                .orElseThrow(() -> new RuntimeException("Location not found with id " + id));
    }

    public void deleteLocation(Integer id) {
        locationRepository.deleteById(id);
    }
}
