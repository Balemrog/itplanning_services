package com.timetech.itplanning_backend.controller;

import com.timetech.itplanning_backend.model.Teacher;
import com.timetech.itplanning_backend.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
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

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> createTeacher(@Valid @RequestBody final Teacher teacher) {
        System.out.println("createTeacher : " + teacher);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(teacher);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = service.getAllTeacher();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(teachers);
/*        return Collections.singletonMap("data",teachers);*/
    }

    @GetMapping("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable final Integer id) {
        System.out.println(id);
        return service.getTeacherById(id);
    }

    @PatchMapping("/teacher")
    public void patchTeacher(@RequestBody final Teacher teacher) {
        System.out.println("patchTeacher" + teacher);
        service.saveTeacher(teacher);
    }

    @DeleteMapping("/teacher/{id}")
    public void deleteTeacher(@PathVariable final Integer id) {
        System.out.println("deleteTeacher" + id);
        service.deleteTeacher(id);
    }
}
