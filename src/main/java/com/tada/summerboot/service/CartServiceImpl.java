package com.tada.summerboot.service;

import com.tada.summerboot.model.CartProduct;
import com.tada.summerboot.model.Post;
import com.tada.summerboot.model.Product;
import com.tada.summerboot.repository.CartRepository;
import com.tada.summerboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements CartServiceInterface{

    @Autowired
    private CartRepository cartRepo;
    // Field injection is not recommended.
    // Please read http://blog.marcnuri.com/field-injection-is-not-recommended/

    @Override
    public void createCartProduct(CartProduct newProduct) {
        cartRepo.save(newProduct);
    }

    @Override
    public Optional<CartProduct> getProduct(Integer id) {
        return cartRepo.findById(id);
    }

    @Override
    public void updateCartProduct(CartProduct updatedProduct) {
        cartRepo.save(updatedProduct);
    }

    @Override
    public void deleteCartProduct(Integer id) {
        Optional<CartProduct> cartProduct = cartRepo.findById(id);
        if(cartProduct.isPresent()){
            cartRepo.delete(cartProduct.get());
        }
    }

    @Override
    public List<CartProduct> getAllCartProducts() {
        return cartRepo.findAll();
    }

    @Override
    public CartProduct createOrUpdateCartProduct(CartProduct entity) {
        if(entity.getId()  == null)
        {
            entity = cartRepo.save(entity);
            return entity;
        }
        else
        {
            Optional<CartProduct> product = cartRepo.findById(entity.getId());

            if(product.isPresent())
            {
                CartProduct newEntity = product.get();
                newEntity.setTitle(entity.getTitle());
                newEntity = cartRepo.save(newEntity);
                return newEntity;
            } else {

                entity = cartRepo.save(entity);
                return entity;
            }
        }
    }

    @Override
    public List<CartProduct> findAllByUserId(Integer id) {
        return cartRepo.findAllCartProductsByUserId(id);
    }
}
