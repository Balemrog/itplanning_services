package com.timetech.itplanning_services.model;

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
    private String modality;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="formation_id", referencedColumnName="id", nullable=false)
    private Formation formation;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="school_class_id", referencedColumnName="id", nullable=false)
    private SchoolClass schoolClass;

    @OneToOne(mappedBy="student", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    public Student(){}

    public Student(String firstName, String lastName, String modality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
    }

    public Student(String firstName, String lastName, String modality, SchoolClass schoolClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.schoolClass = schoolClass;
    }

    public Student(String firstName, String lastName, String modality, SchoolClass schoolClass, Formation formation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.schoolClass = schoolClass;
        this.formation = formation;
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

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", modality=" + modality +
                ", formation=" + formation +
                ", schoolClass=" + schoolClass +
                ", user=" + user +
                '}';
    }
}
