package com.timetech.itplanning_backend.dao;

import com.timetech.itplanning_backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
