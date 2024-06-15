package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.domain.JobAdvertisement;
import ch.fhnw.pizza.data.repository.JobAdvertisementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/jobadvertisement")
public class JobAdvertisementController {

    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;

    @PostMapping(path = "/api/admin/jobs",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
    try {
        JobAdvertisement savedJob = jobAdvertisementRepository.save(jobAdvertisement);
        return ResponseEntity.ok(savedJob);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}