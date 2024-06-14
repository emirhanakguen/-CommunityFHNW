package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.CollaborationsList;
import ch.fhnw.pizza.data.domain.BuddySystem;
import ch.fhnw.pizza.data.repository.BuddySystemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @PostMapping(value = "/api/admin/buddy/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> assignBuddyToInternationalStudent(@RequestBody BuddyAssignmentRequest request) {
        boolean assignmentSuccessful = buddyAssignmentService.assignBuddy(request.getInternationalStudentId(), request.getBuddyId());
        if (assignmentSuccessful) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Buddy assigned successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to assign buddy.");
        }
    }   
} 