package com.timetech.itplanning_services.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Boolean isEmployee;

    @OneToOne(mappedBy="teacher")
    private LessonSession lessonSession;

    @ManyToMany
    @JoinTable(name="demand_teacher",
            joinColumns=@JoinColumn(name="teacher_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="demand_id", referencedColumnName="id")
    )
    private List<Demand> demands;

    @ManyToMany(mappedBy = "teachers")
    private List<Lesson> lessons;

    @OneToOne(mappedBy="teacher")
    @JsonIgnore
    private User user;

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, Boolean isEmployee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isEmployee = isEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getEmployee() {
        return isEmployee;
    }

    public void setEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }

    public LessonSession getLessonSession() {
        return lessonSession;
    }

    public void setLessonSession(LessonSession lessonSession) {
        this.lessonSession = lessonSession;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
