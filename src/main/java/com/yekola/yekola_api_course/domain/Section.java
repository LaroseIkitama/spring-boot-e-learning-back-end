package com.yekola.yekola_api_course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class Section {
    private Long id;

    private String title;

    private Course course;
}
