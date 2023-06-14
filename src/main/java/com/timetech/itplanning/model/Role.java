package com.timetech.itplanning.model;

public enum Role {

    SERVICE_PLANNING("service_planning"),
    TEACHER("teacher"),
    STUDENT("student");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getValue() { return role; }
}
