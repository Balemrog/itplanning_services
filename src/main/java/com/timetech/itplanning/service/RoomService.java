package com.timetech.itplanning.service;

import com.timetech.itplanning.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAllRoom();
    Room getRoomById(Integer id);
    void saveRoom(Room room);
}
