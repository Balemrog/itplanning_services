package com.timetech.itplanning.service;

import com.timetech.itplanning.model.LessonSession;

import java.util.List;

public interface LessonSessionService {

    List<LessonSession> getAllLessonSession();
    LessonSession getLessonSessionById(Integer id);
    void saveLessonSession(LessonSession lessonSession);
}
