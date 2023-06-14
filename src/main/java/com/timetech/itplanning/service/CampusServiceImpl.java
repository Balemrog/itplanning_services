package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class CampusServiceImpl implements CampusService{

    private CampusRepository repository;

    @Autowired
    public CampusServiceImpl(CampusRepository repository){
        this.repository = repository;
    }
}
