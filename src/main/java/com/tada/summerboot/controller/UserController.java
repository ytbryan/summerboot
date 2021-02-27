package com.tada.summerboot.controller;

import com.tada.summerboot.model.User;
import com.tada.summerboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        user_service_implementation.createUser(newUser);
        return "redirect:/every-users";
    }


    @GetMapping(path="/login")
    public String login(Model model) {
        return "login";
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

    @GetMapping(path="/register-admin")
    public String registerAdmin(User newUser) {
        return "register_admin";
    }


    @GetMapping(path="/user/all")
    public List<User> all(){
        return user_service_implementation.getAllUsers();
    }

    @PostMapping(path="/custom_register")
    public String customRegister(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return "";
    }


    @GetMapping(path="/admin")
    public String goToAdmin(){
        return "admin";
    }
}
