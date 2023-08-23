package com.timetech.itplanning_backend.mock;

import com.timetech.itplanning_backend.model.*;
import com.timetech.itplanning_backend.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataMock implements CommandLineRunner {

    private CampusService campusService;
    private DemandService demandService;
    private FormationService formationService;
    private LessonService lessonService;
    private LessonSessionService lessonSessionService;
    private RoomService roomService;
    private StudentService studentService;
    private TeacherService teacherService;

    public DataMock(CampusService campusService, DemandService demandService, FormationService formationService,
                    LessonService lessonService, LessonSessionService lessonSessionService, RoomService roomService,
                    StudentService studentService, TeacherService teacherService) {
        this.campusService = campusService;
        this.demandService = demandService;
        this.formationService = formationService;
        this.lessonService = lessonService;
        this.lessonSessionService = lessonSessionService;
        this.roomService = roomService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    public void addDataSetToDb(){
    }

    @Override
    public void run(String... args) throws Exception {
        Teacher teacher1 = new Teacher(1, "firstname", "lastname", true);
        teacherService.saveTeacher(teacher1);
        Campus campus1 = new Campus(1, "Nantes");
        campusService.saveCampus(campus1);
    }
}
