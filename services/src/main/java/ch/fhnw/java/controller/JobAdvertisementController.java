package services.src.main.java.controller;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.JobAdvertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/jobadvertisement")
public class JobAdvertisementController {

    @PostMapping(path = "/api/admin/jobs",consumes = "application/json",produces = "application/json")
    public ResponseEntity<?> createJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
    try {
        entityManager.persist(jobAdvertisement);
        return ResponseEntity.ok("Job advertisement created successfully.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping(path = "/api/admin/advertisements".consumes = "application/json",produces = "application/json")
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement savedAdvertisement = advertisementService.saveAdvertisement(advertisement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdvertisement);
    }
}