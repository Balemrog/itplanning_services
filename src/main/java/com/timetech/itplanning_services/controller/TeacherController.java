package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.model.Teacher;
import com.timetech.itplanning_services.service.TeacherService;
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
public class TeacherController {

    private TeacherService service;

    @Autowired
    public TeacherController(TeacherService service){
        this.service = service;
    }

    @PostMapping(path = "/teacher", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> createTeacher(@Valid @RequestBody Teacher teacher) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(teacher);
    }

    @GetMapping(path = "/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<Teacher>>> getAllTeachers() {
        List<Teacher> teachers = service.getAllTeacher();
        System.out.println("HEYYYYY");
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonMap("data", teachers));
    }

    @GetMapping(path = "/teacher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getTeacherById(id));
    }

    @DeleteMapping(path = "/teacher/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") Integer id) {
        service.deleteTeacher(id);
        return ResponseEntity.ok("resource deleted");
    }

    @PutMapping(path = "/teacher/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveResource(
            @RequestBody Teacher teacher,
            @PathVariable("id") Integer id) {
//        service.updateTeacher(teacher, id);
        return ResponseEntity.ok("resource saved");
    }

    @PatchMapping(path = "/teacher/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> partialUpdateGeneric(
            @RequestBody Map<String, Object> updates,
            @PathVariable("id") String id) {
//        updates.put("address", "5th avenue");
//        service.partialUpdateTeacher(updates, id);
        return ResponseEntity.ok("resource updated");
    }
}
