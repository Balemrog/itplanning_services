package com.timetech.itplanning.service;

import com.timetech.itplanning.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Integer id);
    void saveTeacher(Teacher teacher);
    void deleteTeacher(Integer id);
}
