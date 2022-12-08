package com.yekola.yekola_api_course.mapper;

import com.yekola.yekola_api_course.domain.Course;
import com.yekola.yekola_api_course.entity.CourseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {

    Course toCourse(CourseEntity courseEntity);

    CourseEntity fromCourse(Course course);
}
