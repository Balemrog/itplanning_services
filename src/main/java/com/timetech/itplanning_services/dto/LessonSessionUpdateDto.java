package com.timetech.itplanning_services.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonSessionUpdateDto {

    @Id
    @NotNull
    private int id;

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

    @Override
    public String toString() {
        return "LessonSessionDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", lesson=" + lesson +
                ", room=" + room +
                ", schoolClass=" + schoolClass +
                ", teacher=" + teacher +
                '}';
    }
}
