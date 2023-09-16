package com.golojan.peticd.controllers;

import com.golojan.peticd.models.Disease;
import com.golojan.peticd.repositories.DiseaseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiseaseController {

    private final DiseaseRepository diseaseRepository;

    public DiseaseController(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Peticd";
    }

    @GetMapping("/disease")
    public ResponseEntity<Iterable<Disease>> getAll() {
        return ResponseEntity.ok(diseaseRepository.findAll());
    }

    @PostMapping("/disease")
    public ResponseEntity<Disease> create(@RequestBody Disease disease) {
        return ResponseEntity.ok(diseaseRepository.save(disease));
    }

    @GetMapping("/disease/{id}")
    public ResponseEntity<Disease> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(diseaseRepository.findById(id).orElse(null));
    }

}
