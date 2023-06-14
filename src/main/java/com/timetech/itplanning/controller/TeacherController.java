package com.timetech.itplanning.controller;

import com.timetech.itplanning.model.Teacher;
import com.timetech.itplanning.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api/v1/teacher")
public class TeacherController {

    private TeacherService service;

    @Autowired
    public TeacherController(TeacherService service){
        this.service = service;
    }

    @GetMapping("/")
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

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return service.getAllTeacher();
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
