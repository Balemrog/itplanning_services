package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.model.Campus;

import java.util.List;

public interface CampusService {

    List<Campus> getAllCampus();
    Campus getCampusById(Integer id);
    void saveCampus(Campus campus);
}
