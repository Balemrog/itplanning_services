package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.dao.DemandRepository;
import com.timetech.itplanning_backend.model.Demand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("default")
public class DemandServiceImpl implements DemandService{

    private DemandRepository repository;

    @Autowired
    public DemandServiceImpl(DemandRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Demand> getAllDemand() {
        return repository.findAll();
    }

    @Override
    public Demand getDemandById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void saveDemand(Demand demand) {
        repository.save(demand);
    }
}
