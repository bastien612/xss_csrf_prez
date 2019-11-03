package com.laboratoire.checklist.controller;

import com.laboratoire.checklist.errors.NotFoundException;
import com.laboratoire.checklist.model.Product;
import com.laboratoire.checklist.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ProductController {

    Logger log = LoggerFactory.getLogger(ProductController.class);



    @Autowired
    private ProductService service;

    @RequestMapping("/product")
    public Product getProduct(@RequestParam(value="name", defaultValue="") String name) {

        Product product = service.findByName(name);

        return product;
    }

    @PostMapping("/product/add")
    public Product addItem(@RequestBody Product product) throws NotFoundException{
        //log.info("Received request on addItem");
        //if (product.getName().equals("")) {
        //    throw new NotFoundException("No product named {" + product + "}");
        //}

        return service.save(product);
    }

    @PostMapping("products/add")
    public void addSet(@RequestBody Set<Product> items) {
        items.forEach(item -> service.save(item));
    }
}