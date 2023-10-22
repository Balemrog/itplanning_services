package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.LessonRepository;
import com.timetech.itplanning_services.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class LessonServiceImpl implements LessonService{

    private final LessonRepository repository;

    @Autowired
    public LessonServiceImpl(LessonRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Lesson> getAllLesson() {
        return repository.findAll();
    }

    @Override
    public Lesson getLessonById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        return repository.save(lesson);
    }

    @Override
    public void deleteLesson(Integer id) {
        repository.deleteById(id);
    }
}
