//package com.laboratoire.checklist.service.productlist;

//import com.laboratoire.checklist.model.ProductList;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductListServiceImpl implements ProductListService{
//
//    @Autowired
//    private ProductListRepository repository;
//
//    public Page<ProductList> findPaginated(int page, int size) {
//
//        return repository.findAll(PageRequest.of(page, size));
//    }
//
//    @Override
//    public ProductList findByTitle(String name) {
//        return repository.findByTitle(name);
//    }
//
//    @Override
//    public ProductList save(ProductList product) {
//        return repository.save(product);
//    }
//}