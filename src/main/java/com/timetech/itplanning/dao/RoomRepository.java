package com.timetech.itplanning.dao;

import com.timetech.itplanning.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}