package com.tada.summerboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
