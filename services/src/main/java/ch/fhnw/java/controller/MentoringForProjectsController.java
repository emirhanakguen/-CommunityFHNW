package services.src.main.java.controller;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.MentoringForProjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/mentoringforprojects")
public class MentoringForProjectsController {

    @PostMapping(path = "/api/projects/mentorship/offers",consumes = "application/json",produces = "application/json")
    public ResponseEntity<MentoringForProjects> createMentoringForProjects(@RequestBody MentoringForProjects mentoringForProjects) {
        MentoringForProjects savedMentoring = mentoringRepository.save(mentoringForProjects);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMentoring);
}
    @GetMapping(path = "/api/projects/mentorship/search?subject={subject}&recurring={true|false}", produces = "application/json")
    public ResponseEntity<List<MentoringForProjects>> getAllMentoringForProjects() {
        List<MentoringForProjects> mentoringList = mentoringRepository.findAll();
        return ResponseEntity.ok(mentoringList);
    }
}