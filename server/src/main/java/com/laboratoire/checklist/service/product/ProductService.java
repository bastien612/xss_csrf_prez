package com.laboratoire.checklist.service.product;

import com.laboratoire.checklist.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public Product findByName(String name);

    public Product save(Product product);

}
