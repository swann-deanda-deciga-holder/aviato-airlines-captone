package com.aviato.demo.controllers;

import org.springframework.ui.Model;
import com.aviato.demo.models.User;
import com.aviato.demo.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute("user") User user, Model model) {
//        User existingUser = userRepository.findByEmail(user.getEmail());
//        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
//            return "redirect:/";
//        } else {
//            model.addAttribute("error", "Invalid email or password");
//            return "login";
//        }
//    }
}
