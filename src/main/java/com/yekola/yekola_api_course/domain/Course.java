package com.yekola.yekola_api_course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private  Long id;
    @NotNull(message = "The title must not be null")
    private String title;
    @NotNull(message = "The description must not be null")
    private String description;
    @NotNull(message = "The image must not be null")
    private String image;
    @NotNull(message = "The video must not be null")
    private String video;
    @NotNull(message = "The duration must not be null")
    private String duration;
    @NotNull(message = "The level must not be null")
    private String level;
    @NotNull(message = "The status must not be null")
    private String status;
}
