package com.timetech.itplanning.dao;

import com.timetech.itplanning.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
