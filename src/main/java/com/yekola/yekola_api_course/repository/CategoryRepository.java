package com.yekola.yekola_api_course.repository;

import com.yekola.yekola_api_course.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository  extends JpaRepository<CategoryEntity,Long> {
    Optional<CategoryEntity> findByNameIgnoreCase(String name);

}
