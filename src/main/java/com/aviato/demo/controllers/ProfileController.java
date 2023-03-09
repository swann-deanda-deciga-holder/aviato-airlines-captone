package com.aviato.demo.controllers;

import com.aviato.demo.models.User;
import com.aviato.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String userProfile(Model model, Principal principal) {
        // Get the currently logged-in user's username
        String username = principal.getName();

        // Retrieve the user's information from the database
        User user = userRepository.findByUsername(username);

        // Pass the user's information to the view
        model.addAttribute("firstName", user.getFirstName());

        // Return the profile view
        return "profile";
    }

}