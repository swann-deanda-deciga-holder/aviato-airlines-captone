package com.aviato.demo.controllers;

import com.aviato.demo.models.User;
import com.aviato.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String userProfile(Model model) {
        //This gets the logged-in user
        //casting because it is a generic object type
        User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", loggedinUser); // pass the entire User object to the view
        return "profile";
    }

    @PostMapping("/profile/edit")
    //This has to be refactored similar to the mapping as above
    public String editProfile(@ModelAttribute("user") User updatedUser, Principal principal) {

        userRepository.save(updatedUser);

        return "redirect:/profile";
    }




}