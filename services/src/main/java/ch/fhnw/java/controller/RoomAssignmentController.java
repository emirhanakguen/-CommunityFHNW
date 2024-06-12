package services.src.main.java.controller;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.RoomAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/roomassignment")
public class RoomAssignmentController {

    @PostMapping(path = "/api/rooms/assign",consumes = "application/json",produces = "application/json")
    public ResponseEntity<RoomAssignment> createRoomAssignment(@RequestBody RoomAssignment roomAssignment) {
        RoomAssignment savedAssignment = roomAssignmentRepository.save(roomAssignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAssignment);
    }
}