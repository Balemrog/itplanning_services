package com.timetech.itplanning_services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonSessionCreationDto {

    @NotBlank
    private String title;

    @NotBlank
    private String start;

    @NotBlank
    private String end;

    @NotNull
    private TeacherDto teacher;

    @NotNull
    private LessonDto lesson;

    @NotNull
    private RoomDto room;

    @NotNull
    private SchoolClassDto schoolClass;

}
