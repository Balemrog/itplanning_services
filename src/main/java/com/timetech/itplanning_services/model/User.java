package com.timetech.itplanning_services.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(max=255)
    private String login;

    @NotBlank
    @Size(max=255)
    private String password;

    @NotNull
    @Column(name = "role", columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name="student_id", updatable=false)
    private Student student;

    @OneToOne
    @JoinColumn(name="teacher_id", updatable=false)
    private Teacher teacher;

    public User(){
    }

    public User(int id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(int id, String login, String password, Role role, Student student) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.student = student;
    }

    public User(int id, String login, String password, Role role, Teacher teacher) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }
}
