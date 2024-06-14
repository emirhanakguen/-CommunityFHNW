package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.domain.IndependentProject;
import ch.fhnw.pizza.data.repository.IndependentProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/independentproject")
public class IndependentProjectController {

    @Autowired
    private IndependentProjectRepository independentProjectRepository;

    @PostMapping(path = "/api/projects/independent",consumes = "application/json",produces = "application/json")
    public ResponseEntity<IndependentProject> createIndependentProject(@RequestBody IndependentProject independentProject) {
        IndependentProject savedProject = independentProjectRepository.save(independentProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }
}