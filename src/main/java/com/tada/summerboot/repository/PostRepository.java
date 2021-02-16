package com.tada.summerboot.repository;

import java.util.List;
import com.tada.summerboot.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    //This interface is used to save/update/read/delete data at`Post` table
    // It ships with methods like .save() or .findById()
    @Query("SELECT n FROM Post n WHERE n.user_id = ?1")
    List<Post> findAllPostsByUserId(Integer user_id);
}
