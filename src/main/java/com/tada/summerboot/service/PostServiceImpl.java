//package com.tada.summerboot.service;
//
//import com.tada.summerboot.model.Post;
//import com.tada.summerboot.repository.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PostServiceImpl implements PostServiceInterface{
//
//    @Autowired
//    private PostRepository postRepo;
//    // Field injection is not recommended. Please read http://blog.marcnuri.com/field-injection-is-not-recommended/
//
//    @Override
//    public void createPost(Post newPost) {
//        postRepo.save(newPost);
//    }
//
//    @Override
//    public Optional<Post> getPost(String id) {
//        return postRepo.findById(id);
//    }
//
//    @Override
//    public void updatePost(Post updatedPost) {
//        postRepo.save(updatedPost);
//    }
//
//    @Override
//    public void deletePost(String id) {
//        Optional<Post> post = postRepo.findById(id);
//        if(post.isPresent()){
//            postRepo.delete(post.get());
//        }
//    }
//
//    @Override
//    public List<Post> getAllPosts() {
//        return postRepo.findAll();
//    }
//
//}
