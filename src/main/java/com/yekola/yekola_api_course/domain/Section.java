package com.yekola.yekola_api_course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Section {
    private Long id;
    @NotNull(message = "The title must not be null")
    private String title;

    private Course course;
}
