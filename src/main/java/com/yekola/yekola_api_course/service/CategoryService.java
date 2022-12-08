package com.yekola.yekola_api_course.service;

import com.yekola.yekola_api_course.domain.Category;
import com.yekola.yekola_api_course.domain.Course;
import com.yekola.yekola_api_course.exception.EntityNotFoundException;
import com.yekola.yekola_api_course.exception.RequestException;
import com.yekola.yekola_api_course.mapper.CategoryMapper;
import com.yekola.yekola_api_course.repository.CategoryRepository;
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
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    MessageSource messageSource;

    public Category createCategory(Category category){
        categoryRepository.findByNameIgnoreCase(category.getName())
                .ifPresent(entity->{
                    throw new RequestException(messageSource.getMessage("category.exists", new Object[]{category.getName()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        log.info("Saving new Castegory: {} to database",category.getName());

        return categoryMapper.toCategory(categoryRepository.save(categoryMapper.fromCategory(category)));
    }

    public Category updateCategory(Category category){
        log.info("Update category: {} ",category.getName());

        return categoryRepository.findById(category.getId())
                .map(entity -> {
                    return categoryMapper.toCategory(
                            categoryRepository.save(categoryMapper.fromCategory(category)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("category.notfound", new Object[]{category.getId()},
                        Locale.getDefault())));
    }

    public void deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
            log.info("Category id: {} has been deleted",id);

        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("category.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    public Category getCategory(Long id) {
        log.info("Fetching category: {} ",id);

        return categoryMapper.toCategory(categoryRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("category.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    public List<Category> getCategories(){
        log.info("Fetching all categories");

        return categoryRepository.findAll().stream()
                .map(categoryMapper::toCategory)
                .collect(Collectors.toList());
    }
}
