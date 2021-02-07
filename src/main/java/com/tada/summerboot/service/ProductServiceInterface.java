package com.tada.summerboot.service;

import com.tada.summerboot.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {
    // implement abstract methods of CRUD
    public void createProduct(Product newProduct);
    public Optional<Product> getProduct(String sku);
    public void updateProduct(Product updatedProduct);
    public void deleteProduct(String sku);
    public List<Product> getAllProduct();
}
