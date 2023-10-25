package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.model.Role;
import com.timetech.itplanning_services.model.Teacher;
import com.timetech.itplanning_services.model.User;
import com.timetech.itplanning_services.service.TeacherService;
import com.timetech.itplanning_services.service.UserService;
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
    private final UserService userService;

    @Autowired
    public TeacherController(TeacherService service, UserService userService){
        this.service = service;
        this.userService = userService;
    }

    @GetMapping(path = "/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<Teacher>>> getAllTeacher() {
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
    public ResponseEntity<?> createTeacher(@Valid @RequestBody Teacher teacher) {
        String login = String.format("%1$s.%2$s@eni.fr", teacher.getFirstName(), teacher.getLastName());
        login.toLowerCase();
        if(!userService.hasUserWithLogin(login)) {
            User user = new User(login, "password", Role.TEACHER, teacher);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(service.saveTeacher(teacher, user));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(String.format("Il existe déjà un enseignant avec les identifiants suivant : ", login));
        }
    }

    @PutMapping(path = "/teachers/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveTeacher(teacher));
    }
}
