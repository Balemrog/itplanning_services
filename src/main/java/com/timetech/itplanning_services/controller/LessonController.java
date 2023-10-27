package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.LessonCreateDto;
import com.timetech.itplanning_services.dto.LessonDto;
import com.timetech.itplanning_services.model.Lesson;
import com.timetech.itplanning_services.service.LessonService;
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
public class LessonController {

    private final LessonService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public LessonController(LessonService service){
        this.service = service;
    }

    @GetMapping(path = "/lessons", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LessonDto> getAllLesson() {
        List<Lesson> lessons = service.getAllLesson();
        return lessons.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/lessons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LessonDto getLessonById(@PathVariable("id") Integer id) {
        Lesson lesson = service.getLessonById(id);
        return modelMapper.map(lesson, LessonDto.class);
    }

    @DeleteMapping(path = "/lessons/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteLesson(@PathVariable("id") Integer id) {
        if (service.getLessonById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteLesson(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/lessons", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LessonDto createLesson(@Valid @RequestBody LessonCreateDto lessonDto) {
        Lesson lesson = modelMapper.map(lessonDto, Lesson.class);
        Lesson lessonCreated = service.saveLesson(lesson);
        return modelMapper.map(lessonCreated, LessonDto.class);
    }

    @PutMapping(path = "/lessons/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public LessonDto updateLesson(@Valid @RequestBody LessonDto lessonDto) {
        Lesson lesson = modelMapper.map(lessonDto, Lesson.class);
        Lesson lessonUpdated = service.saveLesson(lesson);
        return modelMapper.map(lessonUpdated, LessonDto.class);
    }

    private LessonDto convertToDto(Lesson lesson) {
        return modelMapper.map(lesson, LessonDto.class);
    }
}
