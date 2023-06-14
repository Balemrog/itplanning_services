package com.timetech.itplanning.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(max=100)
    private String label;

    @NotNull
    private Date date;

    @NotNull
    private Date duration;

    @NotNull
    @ManyToOne
    private Teacher teacher;

    @NotNull
    @ManyToOne
    private Room room;

    @ManyToMany
    @JoinTable(name="lesson_skill",
            joinColumns=@JoinColumn(name="idLesson", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="idSkill", referencedColumnName="id")
    )
    private List<Skill> lessonSkills;

    public Lesson() {
    }

    public Lesson(int id, String label, Date date, Date duration, Teacher teacher, Room room, List<Skill> lessonSkills) {
        this.id = id;
        this.label = label;
        this.date = date;
        this.duration = duration;
        this.teacher = teacher;
        this.room = room;
        this.lessonSkills = lessonSkills;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Skill> getLessonSkills() {
        return lessonSkills;
    }

    public void setLessonSkills(List<Skill> lessonSkills) {
        this.lessonSkills = lessonSkills;
    }
}
