package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Integer id);
    void saveTeacher(Teacher teacher);
    void saveTeacher(Teacher teacher, Integer id);
    void deleteTeacher(Integer id);
}
