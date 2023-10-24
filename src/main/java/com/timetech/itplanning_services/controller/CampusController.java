package com.timetech.itplanning_services.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.timetech.itplanning_services.model.Campus;
import com.timetech.itplanning_services.model.Views;
import com.timetech.itplanning_services.service.CampusService;
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
public class CampusController {

    private final CampusService service;

    @Autowired
    public CampusController(CampusService service) {
        this.service = service;
    }

    @GetMapping(path = "/campuses", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Public.class)
    public ResponseEntity<Map<String, List<Campus>>> getAllCampus() {
        List<Campus> campuses = service.getAllCampus();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonMap("data", campuses));
    }

    @GetMapping(path = "/campuses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Public.class)
    public ResponseEntity<Campus> getCampusById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getCampusById(id));
    }

    @DeleteMapping(path = "/campuses/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCampus(@PathVariable("id") Integer id) {
        if (service.getCampusById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteCampus(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/campuses", consumes = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Public.class)
    public ResponseEntity<Campus> createCampus(@Valid @RequestBody Campus campus) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveCampus(campus));
    }

    @PutMapping(path = "/campuses/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Public.class)
    public ResponseEntity<Campus> updateCampus(@Valid @RequestBody Campus campus) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveCampus(campus));
    }
}
