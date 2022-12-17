package com.yekola.yekola_api_course.controller;

import com.yekola.yekola_api_course.domain.Chapter;
import com.yekola.yekola_api_course.service.ChapterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/chapters")
@AllArgsConstructor
public class ChapterController {
    ChapterService chapterService;

    @PostMapping("create")
    public ResponseEntity<Chapter> createChapter(@Valid @RequestBody Chapter chapter)
    {
        return ResponseEntity.ok().body(chapterService.createChapter(chapter));
    }

    @PutMapping("update")
    public ResponseEntity<Chapter> updateChapter(@Valid @RequestBody Chapter chapter)
    {
        return ResponseEntity.ok().body(chapterService.updateChapter(chapter));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteChapter(@PathVariable("id") Long id)
    {
        chapterService.deleteChapter(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/get")
    public ResponseEntity<Chapter> getChapter(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(chapterService.getChapter(id));
    }

    @GetMapping()
    public ResponseEntity<List<Chapter>> getChapters(){
        return ResponseEntity.ok().body(chapterService.getChapters());
    }
}
