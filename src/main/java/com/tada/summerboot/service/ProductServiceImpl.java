package com.tada.summerboot.service;

import com.tada.summerboot.repository.ProductRepository;
import com.tada.summerboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductServiceInterface{
    @Autowired
    private ProductRepository productRepo;
    // Field injection is not recommended. Please read http://blog.marcnuri.com/field-injection-is-not-recommended/

    @Override // overriding because we are "overriding" the abstract method
    public void createProduct(Product newProduct) {
        productRepo.save(newProduct);
    }

    @Override
    public void deleteProduct(String sku) {
        Optional<Product> product = productRepo.findById(sku);
        if(product.isPresent()){
            productRepo.delete(product.get());
        }
    }

    @Override
    public Optional<Product> getProduct(String sku) {
        return productRepo.findById(sku);
    }

    @Override
    public void updateProduct(Product updatedProduct) {
        productRepo.save(updatedProduct);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }
}
