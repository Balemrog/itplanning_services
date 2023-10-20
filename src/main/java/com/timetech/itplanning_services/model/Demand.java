package com.timetech.itplanning_services.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "demand")
public class Demand {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String comment;

    @NotBlank
    private Status status;

    @ManyToMany(mappedBy = "demands")
    private List<Teacher> teachers;

    public Demand() {
    }

    public Demand(int id, String comment, Status status, List<Teacher> teachers) {
        this.id = id;
        this.comment = comment;
        this.status = status;
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
