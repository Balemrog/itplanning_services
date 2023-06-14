package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class DemandServiceImpl implements DemandService{

    private DemandRepository repository;

    @Autowired
    public DemandServiceImpl(DemandRepository repository){
        this.repository = repository;
    }
}
