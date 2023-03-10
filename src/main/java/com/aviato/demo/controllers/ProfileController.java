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
import org.springframework.web.bind.annotation.RequestParam;


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
        model.addAttribute("user", userRepository.findById(loggedinUser.getId()).get()); // pass the entire User object to the view
        return "profile";
    }

    @PostMapping("/profile/edit")
    //This has to be refactored similar to the mapping as above
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
//
//    @PostMapping("/profile/delete")
//    public String confirmDeleteProfile(@RequestParam(value = "confirm", required = true) boolean confirm) {
//        if(confirm) {
//            User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            userRepository.delete(loggedinUser);
//            SecurityContextHolder.clearContext();
//            return "redirect:/login?deleted=true";
//        }
//        else {
//            return "redirect:/home";
//        }
//    }





}