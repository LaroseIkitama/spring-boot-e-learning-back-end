package com.yekola.yekola_api_course.mapper;


import com.yekola.yekola_api_course.domain.Section;
import com.yekola.yekola_api_course.entity.SectionEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SectionMapper {
    Section toSection(SectionEntity sectionEntity);

    SectionEntity fromSection(Section section);
}
