package com.tada.summerboot.controller;

import com.tada.summerboot.model.Post;
import com.tada.summerboot.model.Product;
import com.tada.summerboot.service.PostServiceImpl;
import com.tada.summerboot.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.Optional;

@Controller
public class ImageController {
    @Autowired
    PostServiceImpl post_service_implementation;

    @Autowired
    ProductServiceImpl product_service_implementation;

    // Getting from file system
    // Facilitate using of other file-system image storage like Amazon S3
    @GetMapping(value = "post/images/{id}")
    public ResponseEntity<byte[]> fromClasspathAsResEntity(@PathVariable Integer id) throws IOException {
        Optional<Post> post = post_service_implementation.getPost(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(post.get().getImage());
    }


    // Getting from file system
    // Facilitate using of other file-system image storage like Amazon S3
    @GetMapping(value = "product/images/{id}")
    public ResponseEntity<byte[]> fromClasspathAsResEntityForProduct(@PathVariable Integer id) throws IOException {
        Optional<Product> product = product_service_implementation.getProduct(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(product.get().getImage());
    }
}
