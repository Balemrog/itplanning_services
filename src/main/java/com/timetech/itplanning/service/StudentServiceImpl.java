package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.StudentRepository;
import com.timetech.itplanning.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class StudentServiceImpl implements StudentService{

    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void saveStudent(Student student) {
        repository.save(student);
    }
}
