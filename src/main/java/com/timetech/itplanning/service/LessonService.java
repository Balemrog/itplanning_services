package com.timetech.itplanning.service;

import com.timetech.itplanning.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLesson();
    Lesson getLessonById(Integer id);
    void saveLesson(Lesson lesson);
}
