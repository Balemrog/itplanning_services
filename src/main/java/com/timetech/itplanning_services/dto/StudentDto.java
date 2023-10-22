package com.timetech.itplanning_services.dto;

import com.timetech.itplanning_services.model.Modality;

public class StudentDto {

    private String firstName;

    private String lastName;

    private Modality modality;

    public StudentDto(String firstName, String lastName, Modality modality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
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
}
