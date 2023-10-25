package com.timetech.itplanning_services.dto;

import jakarta.validation.constraints.NotNull;

public class CreateLessonSessionRequest {

    @NotNull
    private String title;
    @NotNull
    private String start;
    @NotNull
    private String end;
    @NotNull
    private int teacher;
    @NotNull
    private int lesson;
    @NotNull
    private int room;
    @NotNull
    private int schoolClass;

    public CreateLessonSessionRequest() {
    }

    public CreateLessonSessionRequest(String title, String start, String end, int teacher, int lesson, int room, int schoolClass) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.teacher = teacher;
        this.lesson = lesson;
        this.room = room;
        this.schoolClass = schoolClass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(int schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return "CreateLessonSessionDto{" +
                "title='" + title + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", teacher='" + teacher + '\'' +
                ", lesson='" + lesson + '\'' +
                ", room='" + room + '\'' +
                ", schoolClass='" + schoolClass + '\'' +
                '}';
    }
}
