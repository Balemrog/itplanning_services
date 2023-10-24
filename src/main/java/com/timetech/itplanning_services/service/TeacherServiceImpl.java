package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.TeacherRepository;
import com.timetech.itplanning_services.dao.UserRepository;
import com.timetech.itplanning_services.model.Teacher;
import com.timetech.itplanning_services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return repository.findAll();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher, User user) {
        repository.save(teacher);
        userRepository.save(user);
        return teacher;
    }

    @Override
    public void deleteTeacher(Integer id) {
        repository.deleteById(id);
    }

}
