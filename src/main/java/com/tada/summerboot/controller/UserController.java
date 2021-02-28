package com.tada.summerboot.controller;

import com.tada.summerboot.model.Post;
import com.tada.summerboot.model.Product;
import com.tada.summerboot.model.User;
import com.tada.summerboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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
        return "examples/every-users";
    }

    @GetMapping(path="/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping(path="/every-users")
    public String every(Model model) {
        List<User> list = user_service_implementation.getAllUsers();
        model.addAttribute("users", list);
        return "examples/every-users";
    }

    @GetMapping(path="/register")
    public String register(User newUser) {
        return "examples/register";
    }

    @GetMapping(path="/register-admin")
    public String registerAdmin(User newUser) {
        return "examples/register-admin";
    }


    @GetMapping(path="/user/all")
    public List<User> all(){
        return user_service_implementation.getAllUsers();
    }


    @GetMapping(path="/admin")
    public String goToAdmin(){
        return "examples/admin";
    }

    @GetMapping(path="user/show/{id}")
    public String show(Model model, @PathVariable Integer id) {
        Optional<User> user = user_service_implementation.getUser(id);
        model.addAttribute("user", user);
        return "examples/show-user";
    }

    @RequestMapping(path="user/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String destroy(@PathVariable Integer id) {
        user_service_implementation.deleteUser(id);
        return "examples/every-users";
    }

    @RequestMapping(path = {"user/edit", "user/edit/{id}"})
    public String editPost(Model model, @PathVariable("id") Integer id)
    {
        if (id != null) { // when id is null, because it is not in the database
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = user_service_implementation.current_user();
            model.addAttribute("user", user);
        } else { //else id is present, then we will just create a new entry in the database
            System.out.println("The id is NULL");
            model.addAttribute("post", new Post());
        }
        return "examples/register";
    }
}
