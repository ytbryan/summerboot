package com.tada.summerboot.service;

import com.tada.summerboot.model.Product;
import com.tada.summerboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductServiceInterface{
    @Autowired
    private ProductRepository productRepo;
    // Field injection is not recommended. Please read http://blog.marcnuri.com/field-injection-is-not-recommended/

    @Override
    public void deleteProduct(Integer id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isPresent()){
            productRepo.delete(product.get());
        }
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        return productRepo.findById(id);
    }

    @Override // overriding because we are "overriding" the abstract method
    public void createProduct(Product newProduct) {
        productRepo.save(newProduct);
    }

    @Override
    public void updateProduct(Product updatedProduct) {
        productRepo.save(updatedProduct);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }


    @Override
    public Product createOrUpdateProduct(Product entity)
    {
        if(entity.getId()  == null)
        {
            entity = productRepo.save(entity);
            return entity;
        }
        else
        {
            Optional<Product> product = productRepo.findById(entity.getId());

            if(product.isPresent())
            {
                Product newEntity = product.get();
                newEntity.setTitle(entity.getTitle());
                newEntity.setPrice(entity.getPrice());
                newEntity.setDescription(entity.getDescription());
                newEntity.setSku(entity.getSku());
                newEntity.setQuantity(entity.getQuantity());

                newEntity = productRepo.save(newEntity);

                return newEntity;
            } else {

                entity = productRepo.save(entity);
                return entity;
            }
        }
    }

    @Override
    public List<Product> findAllByUserId(Integer id) {
        return productRepo.findAllProductsByUserId(id);
    }

}
