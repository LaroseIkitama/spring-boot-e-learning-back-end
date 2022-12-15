package com.yekola.yekola_api_course.repository;

import com.yekola.yekola_api_course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    List<CourseEntity> findByStatus(int status);

    @Query("SELECT c FROM CourseEntity c WHERE c.id=1")
    CourseEntity findFirst();
}
