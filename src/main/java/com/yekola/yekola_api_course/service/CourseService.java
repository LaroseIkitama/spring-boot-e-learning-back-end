package com.yekola.yekola_api_course.service;

import com.yekola.yekola_api_course.domain.Course;
import com.yekola.yekola_api_course.exception.EntityNotFoundException;
import com.yekola.yekola_api_course.exception.RequestException;
import com.yekola.yekola_api_course.mapper.CourseMapper;
import com.yekola.yekola_api_course.repository.CourseRepository;
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
public class CourseService {
    CourseRepository courseRepository;

    CourseMapper courseMapper;

    MessageSource messageSource;

    public Course createCourse(Course course) {
        courseRepository.findById(course.getId())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("course.exists", new Object[]{course.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        log.info("Saving new Course: {} to database",course.getTitle());

        return courseMapper.toCourse(courseRepository.save(courseMapper.fromCourse(course)));
    }

    public Course updateCourse(Course course){
        log.info("Update course: {} ",course.getTitle());

        return courseRepository.findById(course.getId())
                .map(entity -> {
                    return courseMapper.toCourse(
                            courseRepository.save(courseMapper.fromCourse(course)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("course.notfound", new Object[]{course.getId()},
                        Locale.getDefault())));
    }

    public void deleteCourse(Long id) {
        try {
            courseRepository.deleteById(id);
            log.info("Course id: {} has been deleted",id);

        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("course.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    public Course getCourse(Long id) {
        log.info("Fetching course: {} ",id);

        return courseMapper.toCourse(courseRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("course.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    public List<Course> getCourses(){
        log.info("Fetching all courses");

        return courseRepository.findAll().stream()
                .map(courseMapper::toCourse)
                .collect(Collectors.toList());
    }

    public List<Course> getDraftCourses(){
        return courseRepository.findByStatus(1).stream()
                .map(courseMapper::toCourse)
                .collect(Collectors.toList());
    }

}
