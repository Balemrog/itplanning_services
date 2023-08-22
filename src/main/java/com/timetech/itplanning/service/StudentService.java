package com.timetech.itplanning.service;

import com.timetech.itplanning.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();
    Student getStudentById(Integer id);
    void saveStudent(Student student);
}
