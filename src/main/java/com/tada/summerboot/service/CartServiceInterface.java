package com.tada.summerboot.service;

import com.tada.summerboot.model.CartProduct;
import java.util.List;
import java.util.Optional;

public interface CartServiceInterface {

    void createCartProduct(CartProduct newProduct);
    Optional<CartProduct> getCartProduct(Integer id);
    void updateCartProduct(CartProduct updatedPost);
    void deleteCartProduct(Integer id);
    List<CartProduct> getAllCartProducts();
    public CartProduct createOrUpdateCartProduct(CartProduct entity);
    List<CartProduct> findAllByUserId(Integer id);
}