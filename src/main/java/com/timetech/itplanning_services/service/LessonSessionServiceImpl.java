package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.LessonSessionRepository;
import com.timetech.itplanning_services.model.LessonSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class LessonSessionServiceImpl implements LessonSessionService {

    private final LessonSessionRepository repository;

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
    public LessonSession saveLessonSession(LessonSession lessonSession) {
        return repository.save(lessonSession);
    }

    @Override
    public void deleteLessonSession(Integer id) {
        repository.deleteById(id);
    }
}
