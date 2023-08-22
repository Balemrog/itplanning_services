package com.timetech.itplanning.model;

public enum Modality {
    PRESENCE("Présentiel"),
    PRESENCE_REMOTE("Hybride"),
    REMOTE("Distanciel");

    private final String modality;

    Modality(String modality) {
        this.modality = modality;
    }

    public String getValue() { return modality; }
}
