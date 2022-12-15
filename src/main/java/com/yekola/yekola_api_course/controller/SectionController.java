package com.yekola.yekola_api_course.controller;

import com.yekola.yekola_api_course.domain.Section;
import com.yekola.yekola_api_course.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/sections")
@AllArgsConstructor
public class SectionController {

    SectionService sectionService;

    @PostMapping("create")
    public ResponseEntity<Section> createSection(@Valid @RequestBody Section section)
    {
        return ResponseEntity.ok().body(sectionService.createSection(section));
    }

    @PutMapping("update")
    public ResponseEntity<Section> updateSection(@Valid @RequestBody Section section)
    {
        return ResponseEntity.ok().body(sectionService.updateSection(section));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteSection(@PathVariable("id") Long id)
    {
        sectionService.deleteSection(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/get")
    public ResponseEntity<Section> getSection(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(sectionService.getSection(id));
    }

    @GetMapping()
    public ResponseEntity<List<Section>> getSections(){
        return ResponseEntity.ok().body(sectionService.getSections());
    }
}
