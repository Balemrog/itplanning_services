package com.timetech.itplanning.service;

import com.timetech.itplanning.model.Demand;

import java.util.List;

public interface DemandService {

    List<Demand> getAllDemand();
    Demand getDemandById(Integer id);
    void saveDemand(Demand demand);
}
