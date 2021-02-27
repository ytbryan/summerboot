package com.tada.summerboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class CartProduct{
    // Notice that Cart is just whatever Product is. Hence, we express
    // such relationship as (Cart extends Product)

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // GenerationType.TABLE will allow auto-increment of id
    private Integer id;

    @Column(nullable = true)
    private BigDecimal price;

    @Column(nullable = true)
    private Integer quantity;

    @Column(nullable = true)
    private String sku;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String productType;

    @Column(nullable = true, length = 64)
    private String imageURL;

    // Required for the @OneToMany relationship with a User
    @Column(name = "user_id")
    private Integer user_id;


    public CartProduct(BigDecimal price, Integer quantity, String sku, String title, String description, Integer user_id) {
//        super(price, quantity, sku, title, description, user_id);
    }

    public CartProduct() {
        super();
    }
}
