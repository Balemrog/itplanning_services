package com.timetech.itplanning_services.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(max=100)
    private String label;

    @NotNull
    @OneToMany(mappedBy = "formation")
    private List<Student> students;

    @ManyToMany(mappedBy = "formations")
    private List<Campus> campusList;

    public Formation() {
    }

    public Formation(int id, String label, List<Student> students) {
        this.id = id;
        this.label = label;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
