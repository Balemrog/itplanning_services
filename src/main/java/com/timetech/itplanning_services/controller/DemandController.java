package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.model.Demand;
import com.timetech.itplanning_services.service.DemandService;
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
@RequestMapping("/api")
public class DemandController {

    private final DemandService service;

    @Autowired
    public DemandController(DemandService service){
        this.service = service;
    }

    @GetMapping(path = "/demands", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<Demand>>> getAllDemand() {
        List<Demand> demands = service.getAllDemand();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonMap("data", demands));
    }

    @GetMapping(path = "/demands/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Demand> getDemandById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getDemandById(id));
    }

    @DeleteMapping(path = "/demands/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteDemand(@PathVariable("id") Integer id) {
        if (service.getDemandById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteDemand(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/demands", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Demand> createDemand(@Valid @RequestBody Demand demand) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveDemand(demand));
    }

    @PutMapping(path = "/demands/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Demand> updateDemand(@Valid @RequestBody Demand demand) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveDemand(demand));
    }
}
