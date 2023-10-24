package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.Teacher;
import com.timetech.itplanning_services.model.User;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Integer id);
    Teacher saveTeacher(Teacher teacher);
    Teacher saveTeacher(Teacher teacher, User user);
    void deleteTeacher(Integer id);
}
