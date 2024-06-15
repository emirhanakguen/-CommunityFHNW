package ch.fhnw.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import ch.fhnw.pizza.data.domain.BuddyAssignment;
import ch.fhnw.pizza.data.repository.BuddyAssignmentRepository;

public class BuddyAssignmentController {

    @Autowired
    private BuddyAssignmentRepository buddyAssignmentRepository;

    @PostMapping(value = "/api/admin/buddy/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> assignBuddyToInternationalStudent(@RequestBody BuddyAssignment buddyassignment) {
        boolean assignmentSuccessful = buddyAssignmentRepository.assignbuddy(buddyassignment.getinternationalstudentId(), buddyassignment.getbuddyId());
        if (assignmentSuccessful) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Buddy assigned successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to assign buddy.");
        }
    }
    
}
