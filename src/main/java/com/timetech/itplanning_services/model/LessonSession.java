package com.timetech.itplanning_services.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lesson_session")
public class LessonSession {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private Date sessionDate;

    @NotNull
    private Date duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="lesson_id", referencedColumnName="id")
    private Lesson lesson;

    @NotNull
    @ManyToMany(mappedBy = "lessonSessions")
    private List<Student> students;

//    @NotNull
//    @OneToMany(mappedBy = "lessonSession")
//    private List<Room> rooms;

    @NotNull
    @OneToOne(optional=false)
    @JoinColumn(name="room_id", nullable=false, updatable=false)
    private Room room;

    @NotNull
    @OneToOne(optional=false)
    @JoinColumn(name="teacher_id", nullable=false, updatable=false)
    private Teacher teacher;

    public LessonSession() {}

    public LessonSession(int id, Date sessionDate, Date duration, Lesson lesson, List<Student> students, Room room, Teacher teacher) {
        this.id = id;
        this.sessionDate = sessionDate;
        this.duration = duration;
        this.lesson = lesson;
        this.students = students;
        this.room = room;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

//    public List<Room> getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(List<Room> rooms) {
//        this.rooms = rooms;
//    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
