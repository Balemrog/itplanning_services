package com.timetech.itplanning_services.mapper;

import com.timetech.itplanning_services.dto.*;
import com.timetech.itplanning_services.model.*;

public interface DtoMapper {

    Teacher toTeacher(TeacherDto teacherDto);

    TeacherDto toTeacherDto(Teacher teacher);

    Teacher setTeacherWithDto(Teacher teacher, TeacherDto teacherDto);

    Campus toCampus(CampusDto campusDto);

    CampusDto toCampusDto(Campus campus);

    Campus setCampusWithDto(Campus campus, CampusDto campusDto);

    Student toStudent(StudentDto studentDto);

    StudentDto toStudentDto(Student student);

    Student setStudentWithDto(Student student, StudentDto studentDto);

    Formation toFormation(FormationDto formationDto);

    FormationDto toFormationDto(Formation formation);

    Formation setFormationWithDto(Formation formation, FormationDto formationDto);

    Room toRoom(RoomDto roomDto);

    RoomDto toRoomDto(Room room);

    Room setRoomWithDto(Room room, RoomDto roomDto);

    Lesson toLesson(LessonDto lessonDto);

    LessonDto toLessonDto(Lesson lesson);

    Lesson setLessonWithDto(Lesson lesson, LessonDto lessonDto);

    Demand toDemand(DemandDto demandDto);

    DemandDto toDemandDto(Demand demand);

    Demand setDemandWithDto(Demand demand, DemandDto demandDto);

    SchoolClassDto toSchoolClassDto(SchoolClass schoolClass);

    SchoolClass setSchoolClassWithDto(SchoolClass schoolClass, SchoolClassDto schoolClassDto);

    LessonSessionDto toLessonSessionDto(LessonSession lessonSession);

    LessonSessionDto toSaveLessonSessionDto(LessonSession lessonSession, Lesson lesson, Room room, SchoolClass schoolClass, Teacher teacher);
}
