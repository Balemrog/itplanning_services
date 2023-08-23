package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.model.Formation;

import java.util.List;

public interface FormationService {

    List<Formation> getAllFormation();
    Formation getFormationById(Integer id);
    void saveFormation(Formation formation);
}
