package com.timetech.itplanning_services.dto;

public class StudentDto {

    private String firstName;

    private String lastName;

    private String modality;

    public StudentDto(String firstName, String lastName, String modality) {
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

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }
}
