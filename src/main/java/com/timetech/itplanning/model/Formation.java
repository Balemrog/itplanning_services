package com.timetech.itplanning.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(max=100)
    private String label;

    @NotBlank
    private Modality modality;

    @NotNull
    @ManyToOne
    private Teacher teacher;

    public Formation() {
    }

    public Formation(int id, String label, Modality modality, Teacher teacher) {
        this.id = id;
        this.label = label;
        this.modality = modality;
        this.teacher = teacher;
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

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
