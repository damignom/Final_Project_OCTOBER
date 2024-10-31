package com.example.Final_Project_OCTOBER.controllers;

import com.example.Final_Project_OCTOBER.models.Product;
import com.example.Final_Project_OCTOBER.models.ProductType;
import com.example.Final_Project_OCTOBER.models.User;
import com.example.Final_Project_OCTOBER.repository.ProductRepository;
import com.example.Final_Project_OCTOBER.repository.ProductTypeRepository;
import com.example.Final_Project_OCTOBER.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class LoginController {
    public static boolean isAuthorised = false;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginIntoSystem(Model model) {
//        Iterable<User> userRepositories = userRepository.findAll();
        User user = new User();
//        model.addAttribute("users", userRepositories);
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
//        User user = new User(email, password);
        User user = userRepository.findByEmail(email);
        System.out.println(user);
        if (user != null && user.getPassword().equals(password)) {
            isAuthorised = true;
            return "redirect:/test";
        }
//        userRepository.save(user);
        User userTwo = new User();
        model.addAttribute("user", userTwo);
        model.addAttribute("error", "Учетные данные не верны");
        return "login"; // учетные данные не верны
    }


}
