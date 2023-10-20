package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.Demand;

import java.util.List;

public interface DemandService {

    List<Demand> getAllDemand();
    Demand getDemandById(Integer id);
    void saveDemand(Demand demand);
}
