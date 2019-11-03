package com.laboratoire.checklist.service.category;

import com.laboratoire.checklist.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {


    public Category findByName(String name);

    public Category save(Category category);
}
