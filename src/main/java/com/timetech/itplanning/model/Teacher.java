package com.timetech.itplanning.model;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Boolean isEmployee;

    @ManyToMany
    @JoinTable(name="skill_teacher",
            joinColumns=@JoinColumn(name="idSkill", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="idTeacher", referencedColumnName="id")
    )
    private List<Skill> teacherSkills;

    @ManyToMany
    @JoinTable(name="demand_teacher",
            joinColumns=@JoinColumn(name="idDemand", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="idTeacher", referencedColumnName="id")
    )
    private List<Demand> demands;

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, Boolean isEmployee, List<Skill> teacherSkills, List<Demand> demands) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isEmployee = isEmployee;
        this.teacherSkills = teacherSkills;
        this.demands = demands;
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

    public Boolean getEmployee() {
        return isEmployee;
    }

    public void setEmployee(Boolean employee) {
        isEmployee = employee;
    }

    public List<Skill> getTeacherSkills() {
        return teacherSkills;
    }

    public void setTeacherSkills(List<Skill> teacherSkills) {
        this.teacherSkills = teacherSkills;
    }

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }
}
