package com.timetech.itplanning.service;

import com.timetech.itplanning.model.Formation;

import java.util.List;

public interface FormationService {

    List<Formation> getAllFormation();
    Formation getFormationById(Integer id);
    void saveFormation(Formation formation);
}
