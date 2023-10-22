package com.timetech.itplanning_services.mapper;

import com.timetech.itplanning_services.dto.TeacherDto;
import com.timetech.itplanning_services.model.Teacher;
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
}
