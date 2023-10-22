package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.CampusRepository;
import com.timetech.itplanning_services.model.Campus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class CampusServiceImpl implements CampusService{

    private final CampusRepository repository;

    @Autowired
    public CampusServiceImpl(CampusRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Campus> getAllCampus() {
        return repository.findAll();
    }

    @Override
    public Campus getCampusById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Campus saveCampus(Campus campus) {
        return repository.save(campus);
    }

    @Override
    public void deleteCampus(Integer id) {
        repository.deleteById(id);
    }
}
