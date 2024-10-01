package com.example.tektokronik.service;

import com.example.tektokronik.model.Image;
import com.example.tektokronik.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image uploadImage(Image image) {
        return imageRepository.save(image);
    }

    public Optional<Image> getImageById(Integer id) {
        return imageRepository.findById(id);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image updateImage(Integer id, Image imageDetails) {
        return imageRepository.findById(id)
                .map(image -> {
                    image.setImageType(imageDetails.getImageType());
                    image.setCaptureDate(imageDetails.getCaptureDate());
                    image.setFilePath(imageDetails.getFilePath());
                    image.setLatitude(imageDetails.getLatitude());
                    image.setLongitude(imageDetails.getLongitude());
                    image.setProcessed(imageDetails.getProcessed());
                    return imageRepository.save(image);
                })
                .orElseThrow(() -> new RuntimeException("Image not found with id " + id));
    }

    public void deleteImage(Integer id) {
        imageRepository.deleteById(id);
    }
}
