package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();
    Student getStudentById(Integer id);
    void saveStudent(Student student);
}
