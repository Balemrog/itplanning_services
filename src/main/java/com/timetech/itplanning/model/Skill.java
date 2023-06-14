package com.timetech.itplanning.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String label;

    @ManyToMany(mappedBy = "teacherSkills")
    private List<Teacher> teachers;

    @ManyToMany(mappedBy = "lessonSkills")
    private List<Lesson> lessons;

    public Skill() {
    }

    public Skill(int id, String label, List<Teacher> teachers, List<Lesson> lessons) {
        this.id = id;
        this.label = label;
        this.teachers = teachers;
        this.lessons = lessons;
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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
