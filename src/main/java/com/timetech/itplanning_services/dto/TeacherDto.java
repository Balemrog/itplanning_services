package com.timetech.itplanning_services.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeacherDto {

    @Id
    @NotNull
    private Integer id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Boolean isEmployee;

    @NotNull
    private List<LessonDto> lessons;

    @Override
    public String toString() {
        return "TeacherDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isEmployee=" + isEmployee +
                ", lessons=" + lessons +
                '}';
    }
}
