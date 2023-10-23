package com.timetech.itplanning_services.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private Modality modality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="formation_id", referencedColumnName="id")
    private Formation formation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="school_class_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SchoolClass schoolClass;

    @OneToOne(mappedBy="student")
    @JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(name="student_lesson_session",
            joinColumns=@JoinColumn(name="student_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="lesson_session_id", referencedColumnName="id")
    )
    private List<LessonSession> lessonSessions;

    public Student(){}

    public Student(String firstName, String lastName, Modality modality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
    }

    public Student(String firstName, String lastName, Modality modality, SchoolClass schoolClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.schoolClass = schoolClass;
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

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LessonSession> getLessonSessions() {
        return lessonSessions;
    }

    public void setLessonSessions(List<LessonSession> lessonSessions) {
        this.lessonSessions = lessonSessions;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
