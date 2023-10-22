package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.Formation;

import java.util.List;

public interface FormationService {

    List<Formation> getAllFormation();
    Formation getFormationById(Integer id);
    Formation saveFormation(Formation formation);
    void deleteFormation(Integer id);
}
