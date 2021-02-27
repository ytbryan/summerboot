package com.tada.summerboot.controller;

import com.tada.summerboot.component.FileUploadUtil;
import com.tada.summerboot.model.Product;
import com.tada.summerboot.model.User;
import com.tada.summerboot.service.ProductServiceImpl;
import com.tada.summerboot.service.UserServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductServiceImpl product_service_implementation;

    @Autowired
    UserServiceImpl user_service_implementation;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    @GetMapping(value="product-image") // it will be set to be /product
    public String productWithImage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = user_service_implementation.current_user(auth.getName());
        model.addAttribute("user", user);
        model.addAttribute("product", new Product());
        return "product-image";
    }

    @PostMapping(path="product/image/new")
    public String newProductWithImage(@RequestParam(name="price") BigDecimal price,
                             @RequestParam(name="quantity") Integer quantity,
                             @RequestParam(name="sku") String sku,
                             @RequestParam(name="title") String title,
                             @RequestParam(name="description") String description,
                             @RequestParam(name="user_id") Integer user_id,
                             @RequestParam(name="image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        System.out.println(fileName);
        logger.debug("Hello from Logback {}");

//        System.out.println("------*------");
//        System.out.println("user_id" + user_id);

        Product new_product = new Product(price, quantity, sku, title, description, user_id);
        product_service_implementation.createOrUpdateProduct(new_product);
        new_product.setImageURL("user-photos/uploads/"+ new_product.getId() + "/" + fileName);
        product_service_implementation.createOrUpdateProduct(new_product);

        String uploadDir = "src/main/resources/static/user-photos/uploads/" + new_product.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return "redirect:/every-products";
    }

    @GetMapping(value="/individual")
    public String everyproductByIndividual(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = user_service_implementation.current_user(auth.getName());
        List<Product> list = product_service_implementation.findAllByUserId(user.getId());
        model.addAttribute("products", list);
        return "individual";
    }

    @GetMapping(value="/every-products")
    public String everyproduct(Model model){
        List<Product> list = product_service_implementation.getAllProduct();
        model.addAttribute("products", list);
        return "every-products";
    }

    @GetMapping(value="product") // it will be set to be /product
    public String product(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = user_service_implementation.current_user(auth.getName());

        model.addAttribute("user", user);
        model.addAttribute("product", new Product());
        return "product";
    }

    @GetMapping(path="product/all", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody
    List<Product> all() {
        return product_service_implementation.getAllProduct();
    }

    // this is for form-data
    @PostMapping(path="product/new")
    public String newProduct(@RequestParam(name="price") BigDecimal price,
                             @RequestParam(name="quantity") Integer quantity,
                             @RequestParam(name="sku") String sku,
                             @RequestParam(name="title") String title,
                             @RequestParam(name="description") String description,
                             @RequestParam(name="user_id") Integer user_id) {

        //        System.out.println("------*------");
        //        System.out.println("user_id" + user_id);

        Product new_product = new Product(price, quantity, sku, title, description, user_id);
        product_service_implementation.createOrUpdateProduct(new_product);
        return "redirect:/every-products";
    }

    // This is for Javascript
    @PostMapping(path="product/json/new", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String newProduct(@RequestBody Product product) {
        product_service_implementation.createOrUpdateProduct(product);
        return "{\"status\": \"success\"}";
    }

    @RequestMapping(path="product/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String destroy(@PathVariable Integer id) {
        product_service_implementation.deleteProduct(id);
        return "redirect:/every-products";
    }

    @GetMapping(path="product/show/{id}")
    public String show(Model model, @PathVariable Integer id) {
        Optional<Product> product = product_service_implementation.getProduct(id);
        model.addAttribute("product", product);
        return "show";
    }

    @RequestMapping(path = {"product/edit", "product/edit/{id}"})
    public String editProduct(Model model, @PathVariable("id") Integer id)
    {
        if (id != null) { // when id is null, because it is not in the database
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = user_service_implementation.current_user(auth.getName());
            model.addAttribute("user", user);

            Optional<Product> entity = product_service_implementation.getProduct(id);
            model.addAttribute("product", entity.get());
        } else { //else id is present, then we will just create a new entry in the database
            model.addAttribute("product", new Product());
        }
        return "product";
    }

}
