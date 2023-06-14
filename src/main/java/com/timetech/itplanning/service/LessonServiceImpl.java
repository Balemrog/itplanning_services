package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class LessonServiceImpl implements  LessonService{

    private LessonRepository repository;

    @Autowired
    public LessonServiceImpl(LessonRepository repository){
        this.repository = repository;
    }
}
