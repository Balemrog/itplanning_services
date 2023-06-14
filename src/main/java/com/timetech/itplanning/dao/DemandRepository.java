package com.timetech.itplanning.dao;

import com.timetech.itplanning.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, Integer> {

}