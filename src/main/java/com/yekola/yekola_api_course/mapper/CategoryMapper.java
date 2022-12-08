package com.yekola.yekola_api_course.mapper;

import com.yekola.yekola_api_course.domain.Category;
import com.yekola.yekola_api_course.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    Category toCategory(CategoryEntity categoryEntity);
    CategoryEntity fromCategory(Category category);
}
