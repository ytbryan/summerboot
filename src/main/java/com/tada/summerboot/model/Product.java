package com.tada.summerboot.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // GenerationType.TABLE will allow auto-increment of id
    private Integer id;
    private BigDecimal price;
    private Integer quantity;
    private String sku;
    private String title;
    private String description;
    private String productType;

    @Column(nullable = true, length = 64)
    private String imageURL;

    // Required for the @OneToMany relationship with a User
    @Column(name = "user_id")
    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Product(BigDecimal price, Integer quantity, String sku, String title, String description, Integer user_id) {
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }

    public Product(Integer id, BigDecimal price, Integer quantity, String sku, String title, String description, Integer user_id) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }

    public Product(Integer id, BigDecimal price, Integer quantity, String sku, String title, String description) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
        this.title = title;
        this.description = description;
    }

    public Product(BigDecimal price, Integer quantity, String sku, String title, String description) {
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
        this.title = title;
        this.description = description;
    }

    public Product(){
        super();
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title +
                ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", sku=" + sku + "]";
    }
}
