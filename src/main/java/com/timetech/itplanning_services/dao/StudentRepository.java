package com.timetech.itplanning_services.dao;

import com.timetech.itplanning_services.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
