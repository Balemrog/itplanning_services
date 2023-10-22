package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();
    Student getStudentById(Integer id);
    Student saveStudent(Student student);
}
