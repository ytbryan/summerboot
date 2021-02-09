//package com.tada.summerboot.controller;
//
//import com.tada.summerboot.model.Post;
//import com.tada.summerboot.service.PostServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Controller
//@RequestMapping(value="/post")
//public class PostController {
//
//    @Autowired
//    PostServiceImpl post_service_implementation;
//
//    @GetMapping // it will be set to be /product
//    public String post(Model model){
//        model.addAttribute("user", "sdfdsfsdfds"); // this will pass the value to a ${user}
//        return "post";
//    }
//
//    @GetMapping(path="all", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public @ResponseBody
//    List<Post> all() {
//        return post_service_implementation.getAllPosts();
//    }
//
//    // this is for form-data
//    @PostMapping(path="/new")
//    public String newProduct(BigDecimal price, Integer quantity, String sku, String title, String description, String imageURL) {
////        Product new_product = new Product(price, quantity, sku,title, description, imageURL);
//        post_service_implementation.createPost(null);
//        // This will redirect to the every product page.
//        return "redirect:/every";
//    }
//
//    //this is for javascript
//    @PostMapping(path="/json/new", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public @ResponseBody String newPost(@RequestBody Post post) {
//        post_service_implementation.createPost(post);
//        return "{\"status\": \"success\"}";
//    }
//
//    // TODO - change to PUT
//    @PutMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public @ResponseBody String update(@PathVariable String id) {
//        post_service_implementation.getPost(id);
//        return "{\"status\": \"success\"}";
//    }
//
//    @GetMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public @ResponseBody
//    String show(@PathVariable String id) {
//        post_service_implementation.getPost(id);
//        return "{\"status\": \"success\"}";
//    }
//
//    //TODO - change to delete
//    @DeleteMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
//    public @ResponseBody
//    String destroy(@PathVariable String id) {
//        post_service_implementation.deletePost(id);
//        return "{\"status\": \"success\"}";
//    }
//}
