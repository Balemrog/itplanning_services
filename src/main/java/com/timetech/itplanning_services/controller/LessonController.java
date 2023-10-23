package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.LessonDto;
import com.timetech.itplanning_services.mapper.DtoMapper;
import com.timetech.itplanning_services.model.Lesson;
import com.timetech.itplanning_services.service.LessonService;
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
public class LessonController {

    private final LessonService service;
    private final DtoMapper dtoMapper;

    @Autowired
    public LessonController(LessonService service, DtoMapper dtoMapper){
        this.service = service;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(path = "/lessons", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<Lesson>>> getAllLesson() {
        List<Lesson> lessons = service.getAllLesson();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonMap("data", lessons));
    }

    @GetMapping(path = "/lessons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Lesson> getLessonById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getLessonById(id));
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
    public ResponseEntity<Lesson> createLesson(@Valid @RequestBody Lesson lesson) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveLesson(lesson));
    }

    @PutMapping(path = "/lessons/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LessonDto> updateLesson(@Valid @RequestBody LessonDto lessonDto, @PathVariable("id") Integer id) {
        Lesson lesson = service.saveLesson(dtoMapper.setLessonWithDto(service.getLessonById(id), lessonDto));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dtoMapper.toLessonDto(lesson));
    }
}
