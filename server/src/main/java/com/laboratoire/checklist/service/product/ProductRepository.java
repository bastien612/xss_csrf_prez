package com.laboratoire.checklist.service.product;

import com.laboratoire.checklist.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product findByName(String name);
}
