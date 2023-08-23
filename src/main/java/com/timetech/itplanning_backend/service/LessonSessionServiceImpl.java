package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.dao.LessonSessionRepository;
import com.timetech.itplanning_backend.model.LessonSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class LessonSessionServiceImpl implements LessonSessionService {

    private LessonSessionRepository repository;

    @Autowired
    public LessonSessionServiceImpl(LessonSessionRepository repository){
        this.repository = repository;
    }

    @Override
    public List<LessonSession> getAllLessonSession() {
        return repository.findAll();
    }

    @Override
    public LessonSession getLessonSessionById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void saveLessonSession(LessonSession lessonSession) {
        repository.save(lessonSession);
    }
}
