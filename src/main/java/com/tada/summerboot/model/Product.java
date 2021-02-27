package com.tada.summerboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
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

    @Column(nullable= true, columnDefinition="mediumblob")
    private byte[] image;

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

    public Product(Integer id, BigDecimal price, Integer quantity, String sku, String title, String description, Integer user_id, byte[] image) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
        this.title = title;
        this.description = description;
        this.user_id = user_id;
        this.image = image;
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
