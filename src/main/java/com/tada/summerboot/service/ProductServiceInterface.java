package com.tada.summerboot.service;

import com.tada.summerboot.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {
    // implement abstract methods of CRUD
    void createProduct(Product newProduct);
    Optional<Product> getProduct(Integer id);
    void updateProduct(Product updatedProduct);
    void deleteProduct(Integer id);

    // an abstract method to get all products for all product page
    List<Product> getAllProduct();

    // create or update product. Two in one method
    Product createOrUpdateProduct(Product entity);

    //Get a list of product of a User
    List<Product> findAllByUserId(Integer id);
}
