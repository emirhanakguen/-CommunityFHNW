package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.CollaborationsList;
import ch.fhnw.pizza.data.domain.Advertisement;
import ch.fhnw.pizza.data.repository.AdvertisementRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class AdvertisementController {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @PostMapping(path = "/api/admin/advertisements",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement savedAdvertisement = advertisementRepository.saveAdvertisement(advertisement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdvertisement);
    }
    
}
