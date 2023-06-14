package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class FormationServiceImpl implements FormationService{

    private FormationRepository repository;

    @Autowired
    public FormationServiceImpl(FormationRepository repository){
        this.repository = repository;
    }
}
