package com.timetech.itplanning.mock;

import com.timetech.itplanning.model.*;
import com.timetech.itplanning.service.*;

public class DataMock {

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
        campusService.saveCampus(new Campus(1,"test"));
    }
}
