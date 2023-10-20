package com.timetech.itplanning_services.dao;

import com.timetech.itplanning_services.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}