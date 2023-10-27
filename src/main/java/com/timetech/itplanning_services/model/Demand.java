//package com.timetech.itplanning_services.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "demand")
//public class Demand {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @NotNull
//    private String comment;
//
//    @NotNull
//    private Status status;
//
//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name="teacher_id", referencedColumnName="id", nullable = false)
//    private Teacher teacher;
//
//    public Demand() {
//    }
//
//    public Demand(String comment, Status status, Teacher teacher) {
//        this.comment = comment;
//        this.status = status;
//        this.teacher = teacher;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//}
