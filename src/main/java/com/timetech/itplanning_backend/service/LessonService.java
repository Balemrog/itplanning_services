package com.timetech.itplanning_backend.service;

import com.timetech.itplanning_backend.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLesson();
    Lesson getLessonById(Integer id);
    void saveLesson(Lesson lesson);
}
