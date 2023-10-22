package com.timetech.itplanning_services.model;

public enum Role {

    SERVICE_PLANNING("SERVICE_PLANNING"),
    TEACHER("TEACHER"),
    STUDENT("STUDENT");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getValue() { return role; }
}
