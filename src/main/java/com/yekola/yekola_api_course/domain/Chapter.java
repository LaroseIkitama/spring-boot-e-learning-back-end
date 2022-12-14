package com.yekola.yekola_api_course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Chapter {
    private Long id;
    @NotNull(message = "The title must not be null")
    private String title;
    @NotNull(message = "The content must not be null")
    private String content;
    private int section;
}
