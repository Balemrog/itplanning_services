package com.timetech.itplanning_services.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LessonSessionDto {

    @Id
    @NotNull
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private LocalDateTime start;

    @NotBlank
    private LocalDateTime end;

    @NotNull
    private LessonDto lesson;

    @NotNull
    private RoomDto room;

    @NotNull
    private SchoolClassDto schoolClass;

    @NotNull
    private TeacherDto teacher;

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
