package com.timetech.itplanning_services.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Boolean isEmployee;

    @OneToOne(mappedBy="teacher")
    private LessonSession lessonSession;

    @OneToMany(mappedBy = "teacher")
    private List<Demand> demands;

    @ManyToMany(mappedBy = "teachers")
    private List<Lesson> lessons;

    @OneToOne(mappedBy="teacher")
    @JsonIgnore
    private User user;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, Boolean isEmployee) {
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

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isEmployee=" + isEmployee +
                ", lessonSession=" + lessonSession +
                ", demands=" + demands +
                ", lessons=" + lessons +
                ", user=" + user +
                '}';
    }
}
