package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAllRoom();
    Room getRoomById(Integer id);
    void saveRoom(Room room);
}
