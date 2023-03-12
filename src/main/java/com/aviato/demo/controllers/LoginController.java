package com.aviato.demo.controllers;

import org.apache.tomcat.util.modeler.BaseAttributeFilter;
import org.springframework.ui.Model;
import com.aviato.demo.models.User;
import com.aviato.demo.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    // Declared an instance variable of type UserRepository //
    private final UserRepository userRepository;

    // Constructor that accepts a UserRepository object and assigns it to the instance variable to access methods //
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method that maps to the "/login" URL and returns the "login" view //

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }




    // Form Validation code, not sure if it works. //

    // Method that handles form submission when the user logs in //

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {

        // Retrieve a User object with the same email address as the submitted form data from the UserRepository//
        User existingUser = userRepository.findByEmail(user.getEmail());


        // If a User object is not found, add an error message to the model and return the "login" view //
        if (existingUser == null) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }

        // If a User object is found, redirect to the home page

        return "redirect:/";
    }
}