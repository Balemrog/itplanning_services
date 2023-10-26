package com.timetech.itplanning_services.model;

import java.util.List;

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

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Demand> demands;

    @ManyToMany
    @JoinTable(name="teachers_lesson",
            joinColumns=@JoinColumn(name="teacher_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="lesson_id", referencedColumnName="id")
    )
    private List<Lesson> lessons;

    @OneToOne(mappedBy="teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, Boolean isEmployee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isEmployee = isEmployee;
    }

    public Teacher(String firstName, String lastName, Boolean isEmployee, List<Lesson> lessons) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isEmployee = isEmployee;
        this.lessons = lessons;
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
