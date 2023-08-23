package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.model.Demand;

import java.util.List;

public interface DemandService {

    List<Demand> getAllDemand();
    Demand getDemandById(Integer id);
    void saveDemand(Demand demand);
}
