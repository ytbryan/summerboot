package com.tada.summerboot.controller;

import com.tada.summerboot.model.CartProduct;
import com.tada.summerboot.service.CartServiceImpl;
import com.tada.summerboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

//    @Autowired
    CartServiceImpl cart_service_implementation;

    @Autowired
    UserServiceImpl user_service_implementation;

    @PostMapping(value="/cart/update")
    public void updateItem(CartProduct updatedProduct){
        cart_service_implementation.createCartProduct(updatedProduct);
    }

    @PostMapping(value="/cart/add")
    public void addItem(CartProduct newItem){
        cart_service_implementation.createCartProduct(newItem);
    }

    @PostMapping(value="/cart/remove/{id}")
    public void removeItem(@PathVariable Integer id){
        cart_service_implementation.deleteCartProduct(id);
    }

    @GetMapping(value="/cart/all")
    public void getAllItems(){
        cart_service_implementation.getAllCartProducts();
    }

    @GetMapping(value="/cart/total")
    public Integer getTotalItem(){
        return 10;
    }
}
