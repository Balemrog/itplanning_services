package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLesson();
    Lesson getLessonById(Integer id);
    Lesson saveLesson(Lesson lesson);
    void deleteLesson(Integer id);
}
