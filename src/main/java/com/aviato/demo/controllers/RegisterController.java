package com.aviato.demo.controllers;

import com.aviato.demo.models.User;
import com.aviato.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


// Defining controller //
@Controller
public class RegisterController {

    // Injecting UserRepo //
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // GET requests to "/register" and adds a new empty "User" object to the model for user-input.
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
<<<<<<< HEAD
        model.addAttribute("user", new User());
=======
        model.addAttribute("user",new User());
>>>>>>> 05bb174aa9342cc57e94181ccb616b912c2af38a
        return "register";
    }

    // POST requests to "/register". Checks users with same email already exists.
    // If so, adds error message to model and returns the "register" view again.
    // Otherwise, encodes user's password and saves user to the database. Finally, it redirects the user to the login page.
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            model.addAttribute("error", "An account with this email already exists");
            return "register";
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "redirect:/login";
    }

}