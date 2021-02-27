package com.tada.summerboot.service;

import com.tada.summerboot.model.CartProduct;
import com.tada.summerboot.model.Product;

import java.util.List;
import java.util.Optional;


public interface CartServiceInterface {
    // implement abstract methods of CRUD
    void createCartProduct(CartProduct newProduct);
    Optional<CartProduct> getProduct(Integer id);
    void updateCartProduct(CartProduct updatedProduct);
    void deleteCartProduct(Integer id);

    // an abstract method to get all products for all product page
    List<CartProduct> getAllCartProducts();

    // create or update product. Two in one method
    CartProduct createOrUpdateCartProduct(CartProduct entity);

    //Get a list of product of a User
    List<CartProduct> findAllByUserId(Integer id);
}
