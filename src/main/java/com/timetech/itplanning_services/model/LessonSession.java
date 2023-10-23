package com.timetech.itplanning_services.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "lesson_session")
public class LessonSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private Date sessionDate;

    @NotNull
    private Date duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lesson_id", referencedColumnName="id")
    private Lesson lesson;


    @NotNull
    @OneToOne(optional=false)
    @JoinColumn(name="room_id", nullable=false, updatable=false)
    private Room room;

    @NotNull
    @OneToOne(optional=false)
    @JoinColumn(name="school_class_id", nullable=false, updatable=false)
    private SchoolClass schoolClass;

    @NotNull
    @OneToOne(optional=false)
    @JoinColumn(name="teacher_id", nullable=false, updatable=false)
    private Teacher teacher;

    public LessonSession() {}

    public LessonSession(Date sessionDate, Date duration, Lesson lesson,  Room room, SchoolClass schoolClass, Teacher teacher) {
        this.sessionDate = sessionDate;
        this.duration = duration;
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

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
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
}
