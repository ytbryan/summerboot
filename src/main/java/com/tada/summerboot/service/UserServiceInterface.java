package com.tada.summerboot.service;

import com.tada.summerboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    void createUser(User newUser);
    Optional<User> getUser(Integer id);
    void updateUser(User updatedUser);
    void deleteUser(Integer id);
    List<User> getAllUsers();

    //an abstract method to get the current user - who is logged in
    User current_user(String name);
}
