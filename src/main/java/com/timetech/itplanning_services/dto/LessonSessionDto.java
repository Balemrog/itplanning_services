package com.timetech.itplanning_services.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class LessonSessionDto {

    private int id;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private LessonDto lessonDto;
    private RoomDto roomDto;
    private SchoolClassDto schoolClassDto;
    private TeacherDto teacherDto;

    public LessonSessionDto() {
    }

    public LessonSessionDto(int id, String title, LocalDateTime start, LocalDateTime end,
                            LessonDto lessonDto, RoomDto roomDto, SchoolClassDto schoolClassDto, TeacherDto teacherDto) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.lessonDto = lessonDto;
        this.roomDto = roomDto;
        this.schoolClassDto = schoolClassDto;
        this.teacherDto = teacherDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LessonDto getLessonDto() {
        return lessonDto;
    }

    public void setLessonDto(LessonDto lessonDto) {
        this.lessonDto = lessonDto;
    }

    public RoomDto getRoomDto() {
        return roomDto;
    }

    public void setRoomDto(RoomDto roomDto) {
        this.roomDto = roomDto;
    }

    public SchoolClassDto getSchoolClassDto() {
        return schoolClassDto;
    }

    public void setSchoolClassDto(SchoolClassDto schoolClassDto) {
        this.schoolClassDto = schoolClassDto;
    }

    public TeacherDto getTeacherDto() {
        return teacherDto;
    }

    public void setTeacherDto(TeacherDto teacherDto) {
        this.teacherDto = teacherDto;
    }

    @Override
    public String toString() {
        return "LessonSessionDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", lessonDto=" + lessonDto +
                ", roomDto=" + roomDto +
                ", schoolClassDto=" + schoolClassDto +
                ", teacherDto=" + teacherDto +
                '}';
    }
}
