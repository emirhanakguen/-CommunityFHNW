package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.domain.BuddySystem;
import ch.fhnw.pizza.data.repository.BuddySystemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/buddysystem")
public class BuddySystemController {

    @Autowired
    private BuddySystemRepository buddySystemRepository;

    @PostMapping(path = "/api/buddy/volunteer",consumes = "application/json",produces = "application/json")
    public ResponseEntity<BuddySystem> createBuddySystem(@RequestBody BuddySystem buddySystem) {
        BuddySystem savedBuddySystem = buddySystemRepository.save(buddySystem);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBuddySystem);
}
    @GetMapping(path = "/api/buddy/match?language={language}",produces = "application/json")
    public ResponseEntity<List<BuddySystem>> getAllBuddySystems(@RequestParam(name = "language") String language) {
        List<BuddySystem> buddySystems = buddySystemRepository.findByLanguage(language);
        return ResponseEntity.ok(buddySystems);
    } 
 
} 