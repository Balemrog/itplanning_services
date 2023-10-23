package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.SchoolClass;

import java.util.List;

public interface SchoolClassService {

    List<SchoolClass> getAllSchoolClass();
    SchoolClass getSchoolClassById(Integer id);
    SchoolClass saveSchoolClass(SchoolClass schoolClass);
    void deleteSchoolClass(Integer id);
}
