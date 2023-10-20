package com.timetech.itplanning_services.model;

public enum Status {

    NOT_SEND("Non envoyée"),
    TO_VALIDATE("À valider"),
    VALIDATE("Valider");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getValue() { return status; }
}
