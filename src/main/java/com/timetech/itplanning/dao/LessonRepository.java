package com.timetech.itplanning.dao;

import com.timetech.itplanning.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}