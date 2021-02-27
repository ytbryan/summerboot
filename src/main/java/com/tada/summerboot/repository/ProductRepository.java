package com.tada.summerboot.repository;

import com.tada.summerboot.model.Product;
import com.tada.summerboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //This interface is used to save/update/read/delete data at`product` table
    // It ships with methods like .save() or .findById()

    //findAllProductByUserId - give the user id and get all the user's products
    @Query("SELECT n FROM Product n WHERE n.user_id = ?1")
    List<Product> findAllProductsByUserId(Integer user_id);
}
