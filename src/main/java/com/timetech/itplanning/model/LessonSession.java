package com.timetech.itplanning.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
    @JoinColumn(name="id_lesson", referencedColumnName="id")
    private Lesson lesson;

    @NotNull
    @OneToMany(mappedBy = "lessonSession")
    private List<Student> students;

    @NotNull
    @OneToMany(mappedBy = "lessonSession")
    private List<Room> rooms;
}
