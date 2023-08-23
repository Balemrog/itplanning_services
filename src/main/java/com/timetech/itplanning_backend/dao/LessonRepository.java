package com.timetech.itplanning_backend.dao;

import com.timetech.itplanning_backend.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}