package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.RoomRepository;
import com.timetech.itplanning_services.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class RoomServiceImpl implements RoomService{

    private RoomRepository repository;

    @Autowired
    public RoomServiceImpl(RoomRepository repository){
        this.repository = repository;
    }


    @Override
    public List<Room> getAllRoom() {
        return repository.findAll();
    }

    @Override
    public Room getRoomById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void saveRoom(Room room) {
        repository.save(room);
    }
}
