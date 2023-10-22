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
        return new TeacherDto(teacher.getFirstName(), teacher.getLastName(), teacher.getIsEmployee());
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
        return new Room(roomDto.getMaterial(), roomDto.getClassName(), roomDto.getRoomName(), roomDto.getBuilding());
    }

    @Override
    public RoomDto toRoomDto(Room room) {
        if (room == null) {
            return null;
        }
        return new RoomDto(room.getMaterial(), room.getClassName(), room.getRoomName(), room.getBuilding());
    }

    @Override
    public Room setRoomWithDto(Room room, RoomDto roomDto) {
        if (roomDto == null || room == null) {
            return null;
        }
        room.setMaterial(roomDto.getMaterial());
        room.setClassName(roomDto.getClassName());
        room.setRoomName(roomDto.getRoomName());
        room.setBuilding(roomDto.getBuilding());
        return room;
    }
}
