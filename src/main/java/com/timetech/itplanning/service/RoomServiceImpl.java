package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class RoomServiceImpl implements RoomService{

    private RoomRepository repository;

    @Autowired
    public RoomServiceImpl(RoomRepository repository){
        this.repository = repository;
    }
}
