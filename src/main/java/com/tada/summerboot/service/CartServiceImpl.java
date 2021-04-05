package com.tada.summerboot.service;

import com.tada.summerboot.model.CartProduct;
import com.tada.summerboot.repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartServiceInterface{

    @Autowired
    private CartProductRepository cartProductRepository;
    // Field injection is not recommended. Please read http://blog.marcnuri.com/field-injection-is-not-recommended/

    @Override
    public void createCartProduct(CartProduct newPost) {
        cartProductRepository.save(newPost);
    }

    @Override
    public Optional<CartProduct> getCartProduct(Integer id) {
        return cartProductRepository.findById(id);
    }

    @Override
    public void updateCartProduct(CartProduct updatedPost) {
        cartProductRepository.save(updatedPost);
    }

    @Override
    public CartProduct createOrUpdateCartProduct(CartProduct entity)
    {
        if(entity.getId()  == null)
        {
            entity = cartProductRepository.save(entity);
            return entity;
        }
        else
        {
            Optional<CartProduct> product = cartProductRepository.findById(entity.getId());

            if(product.isPresent())
            {
                CartProduct newEntity = product.get();
                newEntity.setTitle(entity.getTitle());
//                newEntity.setContent(entity.getContent());
                if(entity.getImage() != null){
                    newEntity.setImage(entity.getImage());
                }
                newEntity = cartProductRepository.save(newEntity);

                return newEntity;
            } else {

                entity = cartProductRepository.save(entity);
                return entity;
            }
        }
    }

    @Override
    public List<CartProduct> getAllCartProducts() {
        return cartProductRepository.findAll();
    }

    @Override
    public List<CartProduct> findAllByUserId(Integer id) {
        return cartProductRepository.findAllCartProductsByUserId(id);
    }

    @Override
    public void deleteCartProduct(Integer id) {
        Optional<CartProduct> post = cartProductRepository.findById(id);
        if(post.isPresent()){
            cartProductRepository.delete(post.get());
        }
    }
}
