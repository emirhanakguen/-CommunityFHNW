package services.src.main.java.controller;

import services.src.main.java.business.CollaborationsList;
import services.src.main.java.data.domain.SystemLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/systemlog")
public class JobAdvertisementController {

    @GetMapping(path = "/api/admin/logs",produces = "application/json")
    public ResponseEntity<List<SystemLog>> getAllSystemLogs() {
        List<SystemLog> systemLogs = systemLogRepository.findAll();
        return ResponseEntity.ok(systemLogs);
    }
}