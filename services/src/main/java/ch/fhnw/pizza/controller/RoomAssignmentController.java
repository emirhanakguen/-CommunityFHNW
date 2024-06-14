package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.domain.RoomAssignment;
import ch.fhnw.pizza.data.repository.RoomAssignmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/roomassignment")
public class RoomAssignmentController {

    @Autowired
    private RoomAssignmentRepository roomAssignmentRepository;

    @PostMapping(path = "/api/rooms/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity<RoomAssignment> createRoomAssignment(@RequestBody RoomAssignment roomAssignment) {
        RoomAssignment savedAssignment = roomAssignmentRepository.save(roomAssignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAssignment);
    }
}