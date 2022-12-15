package com.yekola.yekola_api_course.controller;

import com.yekola.yekola_api_course.domain.Category;
import com.yekola.yekola_api_course.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    CategoryService categoryService;
    @PostMapping("create")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category)
    {
        return ResponseEntity.ok().body(categoryService.createCategory(category));
    }

    @PutMapping("update")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category)
    {
        return ResponseEntity.ok().body(categoryService.updateCategory(category));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id)
    {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("{id}/get")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(categoryService.getCategory(id));
    }
    @GetMapping()
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity.ok().body(categoryService.getCategories());
    }
}
