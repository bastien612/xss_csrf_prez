/*
package com.laboratoire.checklist.controller;

import com.laboratoire.checklist.model.ProductList;
import com.laboratoire.checklist.service.productlist.ProductListRepository;
import com.laboratoire.checklist.service.productlist.ProductListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.model.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ProductListController {

    @Autowired
    private ProductListRepository productListRepository;

    @Autowired
    private ProductListServiceImpl service;

    @RequestMapping(
            value="/lists",
            params = {"page", "size"},
            method = RequestMethod.GET)
    public Page<ProductList> getProductListModelPage(
        @RequestParam("page")int page, @RequestParam("size")int size
    ) {
        return service.findPaginated(1, 1);
    }

    @PostMapping("product_list/add")
    public ProductList addItem(@RequestBody ProductList item) {
        return service.save(item);
    }

    @PostMapping("products_lists/add")
    public void addSet(@RequestBody Set<ProductList> items) {
        items.forEach(item -> service.save(item));
    }

}
*/
