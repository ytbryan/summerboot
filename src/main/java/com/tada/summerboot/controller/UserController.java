package com.tada.summerboot.controller;

import com.tada.summerboot.model.Product;
import com.tada.summerboot.model.User;
import com.tada.summerboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl user_service_implementation;

    @PostMapping(path="/user/new")
    public String newUser(User newUser) {
        user_service_implementation.createUser(newUser);
        return "redirect:/every-users";
    }

    @GetMapping(path="/login")
    public String login(Model model) {
        // if it is already login, redirect to the main page
        return "login";
        // if it is not login, show login
    }

    @GetMapping(path="/every-users")
    public String every(Model model) {
        List<User> list = user_service_implementation.getAllUsers();
        model.addAttribute("users", list);
        return "every-users";
    }

    @GetMapping(path="/register")
    public String register(User newUser) {
        return "register";
    }

    @GetMapping(path="/user/all")
    public List<User> all(){
        return user_service_implementation.getAllUsers();
    }
}
