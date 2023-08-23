package com.timetech.itplanning_backend.dao;

import com.timetech.itplanning_backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}