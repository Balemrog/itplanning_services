package com.timetech.itplanning_services.dto;

public class TeacherDto {

    private String firstName;
    private String lastName;
    private Boolean isEmployee;

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

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
        isEmployee = isEmployee;
    }

    public TeacherDto(String firstName, String lastName, Boolean isEmployee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isEmployee = isEmployee;
    }
}
