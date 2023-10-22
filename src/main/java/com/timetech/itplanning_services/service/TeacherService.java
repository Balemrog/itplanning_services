package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Integer id);
    Teacher saveTeacher(Teacher teacher);
    void deleteTeacher(Integer id);
}
