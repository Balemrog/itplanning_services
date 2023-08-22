package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.LessonSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class LessonSessionServiceImpl implements LessonSessionService {

    private LessonSessionRepository repository;

    @Autowired
    public LessonSessionServiceImpl(LessonSessionRepository repository){
        this.repository = repository;
    }
}
