package com.tada.summerboot.repository;

import com.tada.summerboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    //This interface is used to save/update/read/delete data at`product` table
    // It ships with methods like .save() or .findById()
}
