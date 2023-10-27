package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.TeacherCreationDto;
import com.timetech.itplanning_services.dto.TeacherDto;
import com.timetech.itplanning_services.dto.TeacherUpdateDto;
import com.timetech.itplanning_services.model.Lesson;
import com.timetech.itplanning_services.model.Role;
import com.timetech.itplanning_services.model.Teacher;
import com.timetech.itplanning_services.model.User;
import com.timetech.itplanning_services.service.LessonService;
import com.timetech.itplanning_services.service.TeacherService;
import com.timetech.itplanning_services.service.UserService;
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
public class TeacherController {

    private final TeacherService service;
    private final UserService userService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public TeacherController(TeacherService service, UserService userService){
        this.service = service;
        this.userService = userService;
    }

    @GetMapping(path = "/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeacherDto> getAllTeacher() {
        List<Teacher> teachers = service.getAllTeacher();
        return teachers.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/teachers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDto getTeacherById(@PathVariable("id") Integer id) {
        Teacher teacher = service.getTeacherById(id);
        return modelMapper.map(teacher, TeacherDto.class);
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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createTeacher(@Valid @RequestBody TeacherCreationDto teacherCreationDto) {
        Teacher teacher = modelMapper.map(teacherCreationDto, Teacher.class);

        // Map lesson IDs to Lesson entities
        List<Lesson> lessons = teacherCreationDto.getLessons().stream()
                .map(lessonId -> lessonService.getLessonById(Integer.parseInt(lessonId)))
                .collect(Collectors.toList());

        teacher.setLessons(lessons);

        String login = String.format("%1$s.%2$s@eni.fr", teacherCreationDto.getFirstName(), teacherCreationDto.getLastName()).toLowerCase();
        if(!userService.hasUserWithLogin(login)) {
            User user = new User(login, "password", Role.TEACHER, teacher);
            Teacher teacherCreated = service.saveTeacher(teacher, user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(modelMapper.map(teacherCreated, TeacherDto.class));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(String.format("Il existe déjà un enseignant avec les identifiants suivant : ", login));
        }
    }

    @PutMapping(path = "/teachers/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeacherDto updateTeacher(@Valid @RequestBody TeacherUpdateDto teacherUpdateDto) {
        Teacher teacher = modelMapper.map(teacherUpdateDto, Teacher.class);
        List<Lesson> lessons = teacherUpdateDto.getLessons().stream()
                .map(lessonId -> lessonService.getLessonById(Integer.parseInt(lessonId)))
                .collect(Collectors.toList());
        teacher.setLessons(lessons);

        Teacher teacherUpdated = service.saveTeacher(teacher);
        return modelMapper.map(teacherUpdated, TeacherDto.class);
    }

    private TeacherDto convertToDto(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDto.class);
    }
}
