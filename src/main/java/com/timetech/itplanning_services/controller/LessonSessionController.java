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
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LessonSessionController {

    private final LessonSessionService service;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private SchoolClassService schoolClassService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public LessonSessionController(LessonSessionService service) {
        this.service = service;
    }

    @GetMapping(path = "/lesson-sessions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LessonSessionDto> getAllLessonSession() {
        List<LessonSession> lessonSessions = service.getAllLessonSession();
        return lessonSessions.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/admin/lesson-sessions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LessonSessionDto getLessonSessionById(@PathVariable("id") Integer id) {
        LessonSession lessonSession = service.getLessonSessionById(id);
        return modelMapper.map(lessonSession, LessonSessionDto.class);
    }

    @DeleteMapping(path = "/admin/lesson-sessions/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteLessonSession(@PathVariable("id") Integer id) {
        if (service.getLessonSessionById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteLessonSession(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/admin/lesson-sessions", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LessonSessionDto createLessonSession(@Valid @RequestBody LessonSessionCreationDto lessonSessionCreationDto) {
        LessonSession lessonSession = modelMapper.map(lessonSessionCreationDto, LessonSession.class);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        ZonedDateTime zonedStartDate = ZonedDateTime.parse(lessonSessionCreationDto.getStart(), formatter);
        ZonedDateTime zonedEndDate = ZonedDateTime.parse(lessonSessionCreationDto.getEnd(), formatter);

        LocalDateTime startDate = zonedStartDate.toLocalDateTime();
        LocalDateTime endDate = zonedEndDate.toLocalDateTime();

        lessonSession.setSessionStartDate(startDate);
        lessonSession.setSessionEndDate(endDate);
        service.saveLessonSession(lessonSession);

        return modelMapper.map(lessonSession, LessonSessionDto.class);
    }

    @PutMapping(path = "/admin/lesson-sessions/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public LessonSessionDto updateLessonSession(@Valid @RequestBody LessonSessionUpdateDto lessonSessionUpdateDto) {
        LessonSession lessonSession = modelMapper.map(lessonSessionUpdateDto, LessonSession.class);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        ZonedDateTime zonedStartDate = ZonedDateTime.parse(lessonSessionUpdateDto.getStart(), formatter);
        ZonedDateTime zonedEndDate = ZonedDateTime.parse(lessonSessionUpdateDto.getEnd(), formatter);

        LocalDateTime startDate = zonedStartDate.toLocalDateTime();
        LocalDateTime endDate = zonedEndDate.toLocalDateTime();

        lessonSession.setSessionStartDate(startDate);
        lessonSession.setSessionEndDate(endDate);

        LessonSession lessonSessionUpdated = service.saveLessonSession(lessonSession);
        return modelMapper.map(lessonSessionUpdated, LessonSessionDto.class);
    }

    private LessonSessionDto convertToDto(LessonSession lessonSession) {
        return modelMapper.map(lessonSession, LessonSessionDto.class);
    }
}
