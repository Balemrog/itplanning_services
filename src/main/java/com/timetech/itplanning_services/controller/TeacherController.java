package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.TeacherDto;
import com.timetech.itplanning_services.mapper.DtoMapper;
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
@RequestMapping("/api/admin")
public class TeacherController {

    private final TeacherService service;
    private final DtoMapper dtoMapper;

    @Autowired
    public TeacherController(TeacherService service, DtoMapper dtoMapper){
        this.service = service;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(path = "/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<Teacher>>> getAllTeachers() {
        List<Teacher> teachers = service.getAllTeacher();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonMap("data", teachers));
    }

    @GetMapping(path = "/teachers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getTeacherById(id));
    }

    @DeleteMapping(path = "/teachers/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") Integer id) {
        if (service.getTeacherById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteTeacher(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/teachers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> createTeacher(@Valid @RequestBody Teacher teacher) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveTeacher(teacher));
    }

    @PutMapping(path = "/teachers/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeacherDto> updateTeacher(@Valid @RequestBody TeacherDto teacherDto, @PathVariable("id") Integer id) {
        Teacher teacher = service.saveTeacher(dtoMapper.setTeacherWithDto(service.getTeacherById(id), teacherDto));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dtoMapper.toTeacherDto(teacher));
    }

//    @PatchMapping(path = "/teacher/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> partialUpdateGeneric(
//            @RequestBody Map<String, Object> updates,
//            @PathVariable("id") String id) {
////        updates.put("address", "5th avenue");
////        service.partialUpdateTeacher(updates, id);
//        return ResponseEntity.ok("resource updated");
//    }
}
