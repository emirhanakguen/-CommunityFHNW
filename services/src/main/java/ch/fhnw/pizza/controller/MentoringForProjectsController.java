package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.domain.MentoringForProjects;
import ch.fhnw.pizza.data.repository.MentoringForProjectsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/mentoringforprojects")
public class MentoringForProjectsController {

    @Autowired
    private MentoringForProjectsRepository mentoringForProjectsRepository;

    @PostMapping(path = "/api/projects/mentorship/offers",consumes = "application/json",produces = "application/json")
    public ResponseEntity<MentoringForProjects> createMentoringForProjects(@RequestBody MentoringForProjects mentoringForProjects) {
        MentoringForProjects savedMentoring = mentoringForProjectsRepository.save(mentoringForProjects);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMentoring);
}
    @GetMapping(path = "/api/projects/mentorship/search?subject={subject}&recurring={true|false}", produces = "application/json")
    public ResponseEntity<List<MentoringForProjects>> getAllMentoringForProjects() {
        List<MentoringForProjects> mentoringList = mentoringForProjectsRepository.findAll();
        return ResponseEntity.ok(mentoringList);
    }
}