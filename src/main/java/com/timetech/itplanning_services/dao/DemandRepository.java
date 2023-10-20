package com.timetech.itplanning_services.dao;

import com.timetech.itplanning_services.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, Integer> {

}