package com.yekola.yekola_api_course.service;

import com.yekola.yekola_api_course.domain.Section;
import com.yekola.yekola_api_course.exception.EntityNotFoundException;
import com.yekola.yekola_api_course.exception.RequestException;
import com.yekola.yekola_api_course.mapper.SectionMapper;
import com.yekola.yekola_api_course.repository.SectionRepository;
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
public class SectionService {
    SectionRepository sectionRepository;
    SectionMapper sectionMapper;
    MessageSource messageSource;

    public Section createSection(Section section) {
        sectionRepository.findById(section.getId())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("section.exists", new Object[]{section.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        log.info("Saving new Section: {} to database",section.getTitle());

        return sectionMapper.toSection(sectionRepository.save(sectionMapper.fromSection(section)));
    }

    public Section updateSection(Section section){
        log.info("Update section: {} ",section.getTitle());

        return sectionRepository.findById(section.getId())
                .map(entity -> {
                    return sectionMapper.toSection(
                            sectionRepository.save(sectionMapper.fromSection(section)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("section.notfound", new Object[]{section.getId()},
                        Locale.getDefault())));
    }

    public void deleteSection(Long id) {
        try {
            sectionRepository.deleteById(id);
            log.info("Section id: {} has been deleted",id);

        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("section.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    public Section getSection(Long id) {
        log.info("Fetching section: {} ",id);

        return sectionMapper.toSection(sectionRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("section.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    public List<Section> getSections(){
        log.info("Fetching all sections");

        return sectionRepository.findAll().stream()
                .map(sectionMapper::toSection)
                .collect(Collectors.toList());
    }

}
