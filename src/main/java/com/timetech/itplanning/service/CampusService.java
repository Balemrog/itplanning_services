package com.timetech.itplanning.service;

import com.timetech.itplanning.model.Campus;

import java.util.List;

public interface CampusService {

    List<Campus> getAllCampus();
    Campus getCampusById(Integer id);
    void saveCampus(Campus campus);
}
