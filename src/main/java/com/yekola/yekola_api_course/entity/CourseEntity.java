package com.yekola.yekola_api_course.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    private int user;

    @OneToMany(mappedBy = "course" )
    @JsonIgnore
    private List<SectionEntity> sections;
    @ManyToOne
    private CategoryEntity category;
}
