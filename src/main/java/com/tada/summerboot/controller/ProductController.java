package com.tada.summerboot.controller;

import com.tada.summerboot.model.Product;
import com.tada.summerboot.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(value="/products")
public class ProductController {
    @Autowired
    ProductServiceImpl product_service_implementation;

    @GetMapping(path="all", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody
    List<Product> all() {
        return product_service_implementation.getAllProduct();
    }

    // TODO - change to POST
    // this is for form-data
    @PostMapping(path="/new")
    public String newProduct(BigDecimal price, Integer quantity, String sku, String title, String description) {
        Product new_product = new Product(price, quantity, sku,title, description);
        product_service_implementation.createProduct(new_product);
        return "redirect:/hello";
    }

    //this is for javascript
    @PostMapping(path="/json/new", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String newProduct(@RequestBody Product product) {
        product_service_implementation.createProduct(product);
        return "{\"status\": \"success\"}";
    }

    // TODO - change to PUT
    @PutMapping(path="/edit/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String update(@PathVariable String id) {
        product_service_implementation.getProduct(id);
        return "{\"status\": \"success\"}";
    }

    @GetMapping(path="/product/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody
    String show(@PathVariable String id) {
        product_service_implementation.getProduct(id);
        return "{\"status\": \"success\"}";
    }

    //TODO - change to delete
    @DeleteMapping(path="/product/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody
    String destroy(@PathVariable String id) {
        product_service_implementation.deleteProduct(id);
        return "{\"status\": \"success\"}";
    }

}
