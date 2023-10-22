package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAllRoom();
    Room getRoomById(Integer id);
    Room saveRoom(Room room);
    void deleteRoom(Integer id);
}
