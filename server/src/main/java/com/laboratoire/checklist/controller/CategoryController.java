package com.laboratoire.checklist.controller;

import com.laboratoire.checklist.service.category.CategoryService;
import com.laboratoire.checklist.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RepositoryRestController
public class CategoryController {
//    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService service;

    @PostMapping(
            value = "/categories/add/list")
    public void addSet(@RequestBody List<Category> categories) {
        categories.forEach(category -> service.save(category));
    }
}
