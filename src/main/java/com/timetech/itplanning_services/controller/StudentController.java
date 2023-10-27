package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.*;
import com.timetech.itplanning_services.model.*;
import com.timetech.itplanning_services.service.*;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class StudentController {

    private final StudentService service;
    private final UserService userService;

    @Autowired
    private SchoolClassService schoolClassService;
    @Autowired
    private FormationService formationService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public StudentController(StudentService service, UserService userService){
        this.service = service;
        this.userService = userService;
    }

    @GetMapping(path = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDto> getAllStudent() {
        List<Student> students = service.getAllStudent();
        return students.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDto getStudentById(@PathVariable("id") Integer id) {
        Student student = service.getStudentById(id);
        return modelMapper.map(student, StudentDto.class);
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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentCreationDto studentCreationDto) {
        Student student = modelMapper.map(studentCreationDto, Student.class);
        String login = String.format("%1$s.%2$s@eni.fr", studentCreationDto.getFirstName(), studentCreationDto.getLastName()).toLowerCase();
        if(!userService.hasUserWithLogin(login)) {
            User user = new User(login, "password", Role.STUDENT, student);
            Student studentCreated = service.saveStudent(student, user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(modelMapper.map(studentCreated, StudentDto.class));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(String.format("Il existe déjà un élève avec les identifiants suivant : ", login));
        }
    }

    @PutMapping(path = "/students/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentDto updateStudent(@Valid @RequestBody StudentUpdateDto studentUpdateDto) {
        Student student = modelMapper.map(studentUpdateDto, Student.class);
        Student studentUpdated = service.saveStudent(student);
        return modelMapper.map(studentUpdated, StudentDto.class);
    }

    private StudentDto convertToDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }
}
