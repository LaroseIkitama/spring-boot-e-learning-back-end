package com.yekola.yekola_api_course.mapper;

import com.yekola.yekola_api_course.domain.Chapter;
import com.yekola.yekola_api_course.entity.ChapterEntity;

import org.mapstruct.Mapper;

@Mapper
public interface ChapterMapper {
    Chapter toChapter(ChapterEntity chapterEntity);

    ChapterEntity fromChapter(Chapter chapter);
}
