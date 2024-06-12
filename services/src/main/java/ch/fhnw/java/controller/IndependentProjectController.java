package services.src.main.java.controller;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.IndependentProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/independentproject")
public class IndependentProjectController {

    @PostMapping(path = "/api/projects/independent",consumes = "application/json",produces = "application/json")
    public ResponseEntity<IndependentProject> createIndependentProject(@RequestBody IndependentProject independentProject) {
        IndependentProject savedProject = independentProjectRepository.save(independentProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }
}