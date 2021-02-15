package com.tada.summerboot.service;

import com.tada.summerboot.model.User;
import com.tada.summerboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface{

    @Autowired
    private UserRepository userRepo;

    @Override
    public void createUser(User newUser) {
        userRepo.save(newUser);
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void updateUser(User updatedUser) {
        userRepo.save(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            userRepo.delete(user.get());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User current_user(String name) {
        System.out.println(name);
        User u = userRepo.findByUsername(name);
        System.out.println(u);
        System.out.println(u.getId());
        System.out.println(u.getUsername());

        return u;
    }
}
