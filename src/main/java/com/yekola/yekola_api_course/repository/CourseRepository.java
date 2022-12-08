package com.yekola.yekola_api_course.repository;

import com.yekola.yekola_api_course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
}
