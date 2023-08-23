package com.timetech.itplanning_backend.dao;

import com.timetech.itplanning_backend.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, Integer> {

}