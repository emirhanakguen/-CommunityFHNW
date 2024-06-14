package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.CollaborationsList;
import ch.fhnw.pizza.data.domain.SystemLog;
import ch.fhnw.pizza.data.repository.SystemLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/systemlog")
public class SystemLogController {

    @Autowired
    private SystemLogRepository systemLogRepository;

    @GetMapping(path = "/api/admin/logs",produces = "application/json")
    public ResponseEntity<List<SystemLog>> getAllSystemLogs() {
        List<SystemLog> systemLogs = systemLogRepository.findAll();
        return ResponseEntity.ok(systemLogs);
    }
}