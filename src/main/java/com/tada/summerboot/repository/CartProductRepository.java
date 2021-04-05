package com.tada.summerboot.repository;

import com.tada.summerboot.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
    //This interface is used to save/update/read/delete data at`product` table
    // It ships with methods like .save() or .findById()

    @Query("SELECT n FROM CartProduct n WHERE n.user_id = ?1")
    List<CartProduct> findAllCartProductsByUserId(Integer user_id);
}
