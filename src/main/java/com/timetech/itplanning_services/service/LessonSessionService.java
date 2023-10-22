package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.LessonSession;

import java.util.List;

public interface LessonSessionService {

    List<LessonSession> getAllLessonSession();
    LessonSession getLessonSessionById(Integer id);
    LessonSession saveLessonSession(LessonSession lessonSession);
}
