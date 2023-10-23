package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.SchoolClassRepository;
import com.timetech.itplanning_services.model.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class SchoolClassServiceImpl implements SchoolClassService{

    private final SchoolClassRepository repository;

    @Autowired
    public SchoolClassServiceImpl(SchoolClassRepository repository){
        this.repository = repository;
    }


    @Override
    public List<SchoolClass> getAllSchoolClass() {
        return repository.findAll();
    }

    @Override
    public SchoolClass getSchoolClassById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public SchoolClass saveSchoolClass(SchoolClass schoolClass) {
        return repository.save(schoolClass);
    }

    @Override
    public void deleteSchoolClass(Integer id) {
        repository.deleteById(id);
    }
}
