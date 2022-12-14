package com.yekola.yekola_api_course.service;

import com.yekola.yekola_api_course.domain.Chapter;
import com.yekola.yekola_api_course.exception.EntityNotFoundException;
import com.yekola.yekola_api_course.exception.RequestException;
import com.yekola.yekola_api_course.mapper.ChapterMapper;
import com.yekola.yekola_api_course.repository.ChapterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class ChapterService {

    ChapterRepository chapterRepository;
    ChapterMapper chapterMapper;
    MessageSource messageSource;

    public Chapter createChapter(Chapter chapter) {
        chapterRepository.findById(chapter.getId())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("chapter.exists", new Object[]{chapter.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        log.info("Saving new Chapter: {} to database",chapter.getTitle());

        return chapterMapper.toChapter(chapterRepository.save(chapterMapper.fromChapter(chapter)));
    }

    public Chapter updateChapter(Chapter chapter){
        log.info("Update chapter: {} ",chapter.getTitle());

        return chapterRepository.findById(chapter.getId())
                .map(entity -> {
                    return chapterMapper.toChapter(
                            chapterRepository.save(chapterMapper.fromChapter(chapter)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("chapter.notfound", new Object[]{chapter.getId()},
                        Locale.getDefault())));
    }

    public void deleteChapter(Long id) {
        try {
            chapterRepository.deleteById(id);
            log.info("Chapter id: {} has been deleted",id);

        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("chapter.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    public Chapter getChapter(Long id) {
        log.info("Fetching chapter: {} ",id);

        return chapterMapper.toChapter(chapterRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("chapter.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    public List<Chapter> getChapters(){
        log.info("Fetching all chapters");

        return chapterRepository.findAll().stream()
                .map(chapterMapper::toChapter)
                .collect(Collectors.toList());
    }

}
