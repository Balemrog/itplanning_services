package com.timetech.itplanning_services.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Modality {
    @JsonProperty("Présentiel")
    PRESENCE,
    @JsonProperty("Hybride")
    PRESENCE_REMOTE,
    @JsonProperty("Distanciel")
    REMOTE;
}