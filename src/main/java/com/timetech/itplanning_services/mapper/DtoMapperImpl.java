package com.timetech.itplanning_services.mapper;

import com.timetech.itplanning_services.dto.*;
import com.timetech.itplanning_services.model.*;
import org.springframework.stereotype.Service;

@Service
public class DtoMapperImpl implements DtoMapper{

    @Override
    public Teacher toTeacher(TeacherDto teacherDto) {
        if (teacherDto == null) {
            return null;
        }
        return new Teacher(teacherDto.getFirstName(), teacherDto.getLastName(), teacherDto.getIsEmployee());
    }

    @Override
    public TeacherDto toTeacherDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        return new TeacherDto(teacher.getId(), teacher.getFirstName(), teacher.getLastName(), teacher.getIsEmployee());
    }

    @Override
    public Teacher setTeacherWithDto(Teacher teacher, TeacherDto teacherDto) {
        if (teacherDto == null || teacher == null) {
            return null;
        }
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setIsEmployee(teacherDto.getIsEmployee());
        return teacher;
    }

    @Override
    public Campus toCampus(CampusDto campusDto) {
        if (campusDto == null) {
            return null;
        }
        return new Campus(campusDto.getLocation());
    }

    @Override
    public CampusDto toCampusDto(Campus campus) {
        if (campus == null) {
            return null;
        }
        return new CampusDto(campus.getLocation());
    }

    @Override
    public Campus setCampusWithDto(Campus campus, CampusDto campusDto) {
        if (campusDto == null || campus == null) {
            return null;
        }
        campus.setLocation(campusDto.getLocation());
        return campus;
    }

    @Override
    public Student toStudent(StudentDto studentDto) {
        if (studentDto == null) {
            return null;
        }
        return new Student(studentDto.getFirstName(), studentDto.getLastName(), studentDto.getModality());
    }

    @Override
    public StudentDto toStudentDto(Student student) {
        if (student == null) {
            return null;
        }
        return new StudentDto(student.getFirstName(), student.getLastName(), student.getModality());
    }

    @Override
    public Student setStudentWithDto(Student student, StudentDto studentDto) {
        if (studentDto == null || student == null) {
            return null;
        }
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setModality(studentDto.getModality());
        return student;
    }

    @Override
    public Formation toFormation(FormationDto formationDto) {
        if (formationDto == null) {
            return null;
        }
        return new Formation(formationDto.getLabel());
    }

    @Override
    public FormationDto toFormationDto(Formation formation) {
        if (formation == null) {
            return null;
        }
        return new FormationDto(formation.getLabel());
    }

    @Override
    public Formation setFormationWithDto(Formation formation, FormationDto formationDto) {
        if (formationDto == null || formation == null) {
            return null;
        }
        formation.setLabel(formationDto.getLabel());
        return formation;
    }

    @Override
    public Room toRoom(RoomDto roomDto) {
        if (roomDto == null) {
            return null;
        }
        return new Room(roomDto.getMaterial(), roomDto.getRoomName(), roomDto.getBuilding());
    }

    @Override
    public RoomDto toRoomDto(Room room) {
        if (room == null) {
            return null;
        }
        return new RoomDto(room.getId(), room.getMaterial(), room.getRoomName(), room.getBuilding());
    }

    @Override
    public Room setRoomWithDto(Room room, RoomDto roomDto) {
        if (roomDto == null || room == null) {
            return null;
        }
        room.setMaterial(roomDto.getMaterial());
        room.setRoomName(roomDto.getRoomName());
        room.setBuilding(roomDto.getBuilding());
        return room;
    }

    @Override
    public Lesson toLesson(LessonDto lessonDto) {
        if (lessonDto == null) {
            return null;
        }
        return new Lesson(lessonDto.getLabel());
    }

    @Override
    public LessonDto toLessonDto(Lesson lesson) {
        if (lesson == null) {
            return null;
        }
        return new LessonDto(lesson.getId(), lesson.getLabel());
    }

    @Override
    public Lesson setLessonWithDto(Lesson lesson, LessonDto lessonDto) {
        if (lessonDto == null || lesson == null) {
            return null;
        }
        lesson.setLabel(lessonDto.getLabel());
        return lesson;
    }

    @Override
    public Demand toDemand(DemandDto demandDto) {
        if (demandDto == null) {
            return null;
        }
        return new Demand(demandDto.getComment(), demandDto.getStatus(), demandDto.getTeacher());
    }

    @Override
    public DemandDto toDemandDto(Demand demand) {
        if (demand == null) {
            return null;
        }
        return new DemandDto(demand.getComment(), demand.getStatus(), demand.getTeacher());
    }

    @Override
    public Demand setDemandWithDto(Demand demand, DemandDto demandDto) {
        if (demandDto == null || demand == null) {
            return null;
        }
        demand.setComment(demandDto.getComment());
        demand.setStatus(demandDto.getStatus());
        demand.setTeacher(demandDto.getTeacher());
        return demand;
    }

    @Override
    public SchoolClassDto toSchoolClassDto(SchoolClass schoolClass) {
        if (schoolClass == null) {
            return null;
        }
        return new SchoolClassDto(schoolClass.getId(), schoolClass.getLabel());
    }

    @Override
    public SchoolClass setSchoolClassWithDto(SchoolClass schoolClass, SchoolClassDto schoolClassDto) {
        if (schoolClassDto == null || schoolClass == null) {
            return null;
        }
        schoolClass.setLabel(schoolClassDto.getLabel());
        return schoolClass;
    }

    @Override
    public LessonSessionDto toLessonSessionDto(LessonSession lessonSession) {
        if (lessonSession == null) {
            return null;
        }
        return new LessonSessionDto(lessonSession.getId(), lessonSession.getTitle(),
                lessonSession.getSessionStartDate(), lessonSession.getSessionEndDate(), toLessonDto(lessonSession.getLesson()),
                toRoomDto(lessonSession.getRoom()), toSchoolClassDto(lessonSession.getSchoolClass()), toTeacherDto(lessonSession.getTeacher()));
    }

    @Override
    public LessonSessionDto toSaveLessonSessionDto(LessonSession lessonSession, Lesson lesson, Room room, SchoolClass schoolClass, Teacher teacher) {
        if (lessonSession == null) {
            return null;
        }
        return new LessonSessionDto(lessonSession.getId(), lessonSession.getTitle(),
                lessonSession.getSessionStartDate(), lessonSession.getSessionEndDate(), toLessonDto(lesson),
                toRoomDto(room), toSchoolClassDto(schoolClass), toTeacherDto(teacher));
    }
}
