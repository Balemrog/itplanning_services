package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.StudentDto;
import com.timetech.itplanning_services.mapper.DtoMapper;
import com.timetech.itplanning_services.model.Student;
import com.timetech.itplanning_services.service.StudentService;
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
public class StudentController {

    private final StudentService service;
    private final DtoMapper dtoMapper;

    @Autowired
    public StudentController(StudentService service, DtoMapper dtoMapper){
        this.service = service;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(path = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<Student>>> getAllStudents() {
        List<Student> students = service.getAllStudent();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonMap("data", students));
    }

    @GetMapping(path = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getStudentById(id));
    }

    @DeleteMapping(path = "/students/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id) {
        if (service.getStudentById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteStudent(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveStudent(student));
    }

    @PutMapping(path = "/students/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable("id") Integer id) {
        Student student = service.saveStudent(dtoMapper.setStudentWithDto(service.getStudentById(id), studentDto));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dtoMapper.toStudentDto(student));
    }
}
