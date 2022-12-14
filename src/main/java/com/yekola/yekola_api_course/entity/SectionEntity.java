package com.yekola.yekola_api_course.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "sections")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @ManyToOne
    private CourseEntity course;

    @OneToMany(mappedBy = "section" )
    @JsonIgnore
    private List<ChapterEntity> chapters;
}
