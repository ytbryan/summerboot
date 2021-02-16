package com.tada.summerboot.service;

import com.tada.summerboot.model.Post;
import com.tada.summerboot.model.Product;

import java.util.List;
import java.util.Optional;

public interface PostServiceInterface {
    void createPost(Post newPost);
    Optional<Post> getPost(Integer id);
    void updatePost(Post updatedPost);
    void deletePost(Integer id);

    // an abstract method to get all posts for all post page
    List<Post> getAllPosts();
    public Post createOrUpdatePost(Post entity);

    //Get a list of product of a User
    List<Post> findAllByUserId(Integer id);
}
