package com.laboratoire.checklist.service.category;

import com.laboratoire.checklist.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    public Category findByName(String name);
}
