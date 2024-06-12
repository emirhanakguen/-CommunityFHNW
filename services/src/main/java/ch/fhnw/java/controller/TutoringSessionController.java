package services.src.main.java.controller;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.TutoringSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/tutoringsession")
public class TutoringSessionController {
    
    @PostMapping(path = "/api/tutoring/offers",consumes = "application/json",produces = "application/json")
    public ResponseEntity<TutoringSession> createTutoringSession(@RequestBody TutoringSession tutoringSession) {
        TutoringSession savedSession = tutoringSessionRepository.save(tutoringSession);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSession);
}
    @GetMapping(path = "/api/tutoring/search?subject={subject}&recurring={true|false}",produces = "application/json")
    public ResponseEntity<List<TutoringSession>> getAllTutoringSessions(@RequestParam(name = "subject") String subject,
        @RequestParam(name = "recurring", defaultValue = "false") boolean recurring) {
        List<TutoringSession> tutoringSessions = tutoringSessionRepository.findBySubjectAndRecurring(subject, recurring);
        return ResponseEntity.ok(tutoringSessions);
    }    
}