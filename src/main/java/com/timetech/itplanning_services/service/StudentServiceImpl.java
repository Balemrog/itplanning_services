package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.StudentRepository;
import com.timetech.itplanning_services.dao.UserRepository;
import com.timetech.itplanning_services.model.Student;
import com.timetech.itplanning_services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
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
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student saveStudent(Student student, User user) {
        repository.save(student);
        userRepository.save(user);
        return student;
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }
}
