package com.timetech.itplanning_services.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max=100)
    private String label;

    @OneToMany(mappedBy = "lesson")
    private List<LessonSession> lessonSessions;

    @ManyToMany
    @JoinTable(name="lesson_teachers",
            joinColumns=@JoinColumn(name="lesson_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="teacher_id", referencedColumnName="id")
    )
    private List<Teacher> teachers;

    public Lesson() {
    }

    public Lesson(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<LessonSession> getLessonSessions() {
        return lessonSessions;
    }

    public void setLessonSessions(List<LessonSession> lessonSessions) {
        this.lessonSessions = lessonSessions;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
