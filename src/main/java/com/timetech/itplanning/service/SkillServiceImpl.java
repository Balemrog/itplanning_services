package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class SkillServiceImpl implements SkillService{

    private SkillRepository repository;

    @Autowired
    public SkillServiceImpl(SkillRepository repository){
        this.repository = repository;
    }
}
