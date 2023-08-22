package com.timetech.itplanning.service;

import com.timetech.itplanning.dao.FormationRepository;
import com.timetech.itplanning.model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class FormationServiceImpl implements FormationService{

    private FormationRepository repository;

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
    public void saveFormation(Formation formation) {
        repository.save(formation);
    }
}
