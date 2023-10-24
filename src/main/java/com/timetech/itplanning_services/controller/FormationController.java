package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.model.Formation;
import com.timetech.itplanning_services.service.FormationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class FormationController {

    private final FormationService service;

    @Autowired
    public FormationController(FormationService service){
        this.service = service;
    }

    @GetMapping(path = "/formations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<Formation>>> getAllFormations() {
        List<Formation> formations = service.getAllFormation();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonMap("data", formations));
    }

    @GetMapping(path = "/formations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formation> getFormationById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getFormationById(id));
    }

    @DeleteMapping(path = "/formations/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteFormation(@PathVariable("id") Integer id) {
        if (service.getFormationById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteFormation(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/formations", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formation> createFormation(@Valid @RequestBody Formation formation) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveFormation(formation));
    }

    @PutMapping(path = "/formations/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formation> updateFormation(@Valid @RequestBody Formation formation) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveFormation(formation));
    }
}
