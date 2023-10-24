package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.Student;
import com.timetech.itplanning_services.model.User;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();
    Student getStudentById(Integer id);
    Student saveStudent(Student student);
    Student saveStudent(Student student, User user);
    void deleteStudent(Integer id);
}
