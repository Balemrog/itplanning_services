package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.model.LessonSession;

import java.util.List;

public interface LessonSessionService {

    List<LessonSession> getAllLessonSession();
    LessonSession getLessonSessionById(Integer id);
    void saveLessonSession(LessonSession lessonSession);
}
