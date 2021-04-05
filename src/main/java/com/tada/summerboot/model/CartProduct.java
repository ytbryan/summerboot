package com.tada.summerboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class CartProduct {

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

    @Column(nullable= true, columnDefinition="mediumblob")
    private byte[] image;
}
