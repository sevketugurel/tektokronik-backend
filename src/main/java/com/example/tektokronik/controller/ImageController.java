package com.example.tektokronik.controller;

import com.example.tektokronik.model.Image;
import com.example.tektokronik.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<Image> uploadImage(@Valid @RequestBody Image image) {
        Image createdImage = imageService.uploadImage(image);
        return new ResponseEntity<>(createdImage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Integer id) {
        return imageService.getImageById(id)
                .map(image -> new ResponseEntity<>(image, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Integer id, @Valid @RequestBody Image imageDetails) {
        Image updatedImage = imageService.updateImage(id, imageDetails);
        return new ResponseEntity<>(updatedImage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Integer id) {
        imageService.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
