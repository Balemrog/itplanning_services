package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.FormationRepository;
import com.timetech.itplanning_services.model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class FormationServiceImpl implements FormationService{

    private final FormationRepository repository;

    @Autowired
    public FormationServiceImpl(FormationRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Formation> getAllFormation() {
        return repository.findAll();
    }

    @Override
    public Formation getFormationById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Formation saveFormation(Formation formation) {
        return repository.save(formation);
    }

    @Override
    public void deleteFormation(Integer id) {
        repository.deleteById(id);
    }
}
