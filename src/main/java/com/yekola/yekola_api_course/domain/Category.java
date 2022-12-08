package com.yekola.yekola_api_course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    private Long id;
    @NotNull(message = "The name must not be null")
    private String name;
}
