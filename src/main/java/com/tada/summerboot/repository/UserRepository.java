package com.tada.summerboot.repository;

import com.tada.summerboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    //This interface is used to save/update/read/delete data at`product` table
    // It ships with methods like .save() or .findById()
    @Query("SELECT n FROM User n WHERE n.username = ?1")
    User findByUsername(String username);
}
