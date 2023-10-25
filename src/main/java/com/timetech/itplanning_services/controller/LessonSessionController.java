package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.CreateLessonSessionRequest;
import com.timetech.itplanning_services.dto.LessonSessionDto;
import com.timetech.itplanning_services.mapper.DtoMapper;
import com.timetech.itplanning_services.model.*;
import com.timetech.itplanning_services.service.*;
import jakarta.validation.Valid;
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
    private final TeacherService teacherService;
    private final LessonService lessonService;
    private final RoomService roomService;
    private final SchoolClassService schoolClassService;
    private final DtoMapper dtoMapper;

    @Autowired
    public LessonSessionController(LessonSessionService service, TeacherService teacherService, LessonService lessonService,
                                   RoomService roomService, SchoolClassService schoolClassService, DtoMapper dtoMapper) {
        this.service = service;
        this.teacherService = teacherService;
        this.lessonService = lessonService;
        this.roomService = roomService;
        this.schoolClassService = schoolClassService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(path = "/lesson-sessions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LessonSessionDto>> getAllLessonSession() {
        List<LessonSession> lessonSessions = service.getAllLessonSession();
        List<LessonSessionDto> test = lessonSessions.stream().map(dtoMapper::toLessonSessionDto).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(test);
    }

    @GetMapping(path = "/admin/lesson-sessions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LessonSession> getLessonSessionById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getLessonSessionById(id));
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
    public ResponseEntity<LessonSessionDto> createLessonSession(@Valid @RequestBody CreateLessonSessionRequest createLessonSessionRequest) {
        System.out.println("POSTTT LESSON SESSION " + createLessonSessionRequest);
        Teacher teacher = teacherService.getTeacherById(createLessonSessionRequest.getTeacher());
        Lesson lesson = lessonService.getLessonById(createLessonSessionRequest.getLesson());
        Room room = roomService.getRoomById(createLessonSessionRequest.getRoom());
        SchoolClass schoolClass = schoolClassService.getSchoolClassById(createLessonSessionRequest.getSchoolClass());
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        ZonedDateTime zonedStartDate = ZonedDateTime.parse(createLessonSessionRequest.getStart(), formatter);
        ZonedDateTime zonedEndDate = ZonedDateTime.parse(createLessonSessionRequest.getEnd(), formatter);
        LocalDateTime startDate = zonedStartDate.toLocalDateTime();
        LocalDateTime endDate = zonedEndDate.toLocalDateTime();

        LessonSession lessonSession = new LessonSession(createLessonSessionRequest.getTitle(), startDate, endDate, lesson, room, schoolClass, teacher);
        LessonSessionDto lessonSessionDto = dtoMapper.toSaveLessonSessionDto(lessonSession, lesson, room, schoolClass, teacher);

        service.saveLessonSession(lessonSession);
        System.out.println(" inchaaa " + lessonSessionDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(lessonSessionDto);
    }

    @PutMapping(path = "/admin/lesson-sessions/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LessonSession> updateLessonSession(@Valid @RequestBody LessonSession lessonSession) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveLessonSession(lessonSession));
    }
}
