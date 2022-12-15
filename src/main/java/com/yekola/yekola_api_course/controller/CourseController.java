package com.yekola.yekola_api_course.controller;

import com.yekola.yekola_api_course.domain.Course;
import com.yekola.yekola_api_course.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {
    CourseService courseService;
    @PostMapping("create")
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course)
    {
        return ResponseEntity.ok().body(courseService.createCourse(course));
    }

    @PutMapping("update")
    public ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course)
    {
        return ResponseEntity.ok().body(courseService.updateCourse(course));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id)
    {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/get")
    public ResponseEntity<Course> getCourse(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(courseService.getCourse(id));
    }

    @GetMapping("/first")
    public ResponseEntity<Course> getFirstCourse(){
        return ResponseEntity.ok().body(courseService.getFirstCourse());
    }
    @GetMapping()
    public ResponseEntity<List<Course>> getCourses(){
        return ResponseEntity.ok().body(courseService.getCourses());
    }

    @GetMapping("draft")
    public ResponseEntity<List<Course>> getDraftCourses(){return ResponseEntity.ok().body(courseService.getDraftCourses());}
}
