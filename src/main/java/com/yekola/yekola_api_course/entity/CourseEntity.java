package com.yekola.yekola_api_course.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private String video;
    @Column(nullable = false)
    private String duration;
    @Column(nullable = false)
    private String level;
    @Column(nullable = false)
    private int status;
    @Column(nullable = false)
    private int userId;



    @ManyToOne
    private CategoryEntity category;
}
