package com.aviato.demo.controllers;

import com.aviato.demo.models.User;
import com.aviato.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@Controller
public class ProfileController {


    // Injecting instance //
    @Autowired
    private UserRepository userRepository;

    // Method that maps to the "/profile" URL and returns the "profile" view //

    @GetMapping("/profile")
    public String userProfile(Model model) {

        // Retrieve the logged-in User object from the security context //
        User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Add the logged-in User object to the model //
        model.addAttribute("user", userRepository.findById(loggedinUser.getId()).get());

        // Return the "profile" view //
        return "profile";
    }

    // Method that handles form submission when the user edits their profile //
    @PostMapping("/profile/edit")
    public String editProfile(@ModelAttribute User user) {

        // Save the updated User object to the UserRepository //
        userRepository.save(user);

        // Redirect to the "/profile" URL //
        return "redirect:/profile";
    }

    // Method that handles form submission when the user deletes their profile //
    @PostMapping("/profile/delete")
    public String confirmDeleteProfile() {

        // Retrieve the logged-in User object from the security context //
        User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Delete the logged-in User object from the UserRepository //
        userRepository.deleteById(loggedinUser.getId());

        // Redirect to the "/login" URL //
        return "redirect:/login";
    }


}
