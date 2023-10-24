package com.timetech.itplanning_services.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Column(name = "role", columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private Modality modality;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="formation_id", referencedColumnName="id", nullable=false)
    private Formation formation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="school_class_id", referencedColumnName="id", nullable=false)
    private SchoolClass schoolClass;

    @OneToOne(mappedBy="student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private User user;

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

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
