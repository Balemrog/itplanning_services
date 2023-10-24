package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.model.SchoolClass;
import com.timetech.itplanning_services.service.SchoolClassService;
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
public class SchoolClassController {

    private final SchoolClassService service;

    @Autowired
    public SchoolClassController(SchoolClassService service){
        this.service = service;
    }

    @GetMapping(path = "/school-classes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<SchoolClass>>> getAllSchoolClass() {
        List<SchoolClass> schoolClasses = service.getAllSchoolClass();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonMap("data", schoolClasses));
    }

    @GetMapping(path = "/school-classes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolClass> getSchoolClassById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getSchoolClassById(id));
    }

    @DeleteMapping(path = "/school-classes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteSchoolClass(@PathVariable("id") Integer id) {
        if (service.getSchoolClassById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteSchoolClass(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/school-classes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolClass> createSchoolClass(@Valid @RequestBody SchoolClass schoolClass) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveSchoolClass(schoolClass));
    }

    @PutMapping(path = "/school-classes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolClass> updateSchoolClass(@Valid @RequestBody SchoolClass schoolClass) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveSchoolClass(schoolClass));
    }
}
