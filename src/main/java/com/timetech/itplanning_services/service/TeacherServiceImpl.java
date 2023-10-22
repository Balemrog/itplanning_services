package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.TeacherRepository;
import com.timetech.itplanning_services.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository){
        this.repository = repository;
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
    public void deleteTeacher(Integer id) {
        repository.deleteById(id);
    }

}
