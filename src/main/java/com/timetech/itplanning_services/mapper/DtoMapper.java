package com.timetech.itplanning_services.mapper;

import com.timetech.itplanning_services.dto.TeacherDto;
import com.timetech.itplanning_services.model.Teacher;

public interface DtoMapper {

    Teacher toTeacher(TeacherDto teacherDto);

    TeacherDto toTeacherDto(Teacher teacher);

    Teacher setTeacherWithDto(Teacher teacher, TeacherDto teacherDto);

}
