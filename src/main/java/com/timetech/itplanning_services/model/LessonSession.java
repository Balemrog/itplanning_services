package com.timetech.itplanning_services.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "lesson_session")
public class LessonSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;

    @NotNull
    private LocalDateTime sessionStartDate;

    @NotNull
    private LocalDateTime sessionEndDate;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="lesson_id", referencedColumnName="id", nullable = false)
    @JsonIgnore
    private Lesson lesson;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="room_id", nullable=false)
    @JsonIgnore
    private Room room;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="school_class_id", referencedColumnName="id", nullable=false)
    @JsonIgnore
    private SchoolClass schoolClass;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="teacher_id", referencedColumnName="id", nullable=false)
    @JsonIgnore
    private Teacher teacher;

    public LessonSession() {}

    public LessonSession(String title, LocalDateTime sessionStartDate, LocalDateTime sessionEndDate, Lesson lesson,  Room room, SchoolClass schoolClass, Teacher teacher) {
        this.title = title;
        this.sessionStartDate = sessionStartDate;
        this.sessionEndDate = sessionEndDate;
        this.lesson = lesson;
        this.room = room;
        this.schoolClass = schoolClass;
        this.teacher = teacher;
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

    public LocalDateTime getSessionStartDate() {
        return sessionStartDate;
    }

    public void setSessionStartDate(LocalDateTime sessionStartDate) {
        this.sessionStartDate = sessionStartDate;
    }

    public LocalDateTime getSessionEndDate() {
        return sessionEndDate;
    }

    public void setSessionEndDate(LocalDateTime sessionEndDate) {
        this.sessionEndDate = sessionEndDate;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "LessonSession{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sessionStartDate=" + sessionStartDate +
                ", sessionEndDate=" + sessionEndDate +
                ", lesson=" + lesson +
                ", room=" + room +
                ", schoolClass=" + schoolClass +
                ", teacher=" + teacher +
                '}';
    }
}
