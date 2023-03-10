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

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String userProfile(Model model) {
        User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userRepository.findById(loggedinUser.getId()).get());
        return "profile";
    }

    @PostMapping("/profile/edit")
    public String editProfile(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/profile";
    }


    // DELETE PROFILE FUNCTIONALITY //

//    @GetMapping("/profile/delete")
//    public String deleteProfile(Model model) {
//        User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", userRepository.findById(loggedinUser.getId()).get());
//        return "delete-profile";
//    }

    @PostMapping("/profile/delete")
    public String confirmDeleteProfile() {
        User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userRepository.deleteById(loggedinUser.getId());
        return "redirect:/login";
    }


}
