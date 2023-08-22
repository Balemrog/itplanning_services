package com.timetech.itplanning.dao;

import com.timetech.itplanning.model.LessonSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonSessionRepository extends JpaRepository<LessonSession, Integer> {

}
