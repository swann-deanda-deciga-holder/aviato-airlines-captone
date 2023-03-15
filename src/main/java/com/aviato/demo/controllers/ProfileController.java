package com.aviato.demo.controllers;

import com.aviato.demo.models.Flight;
import com.aviato.demo.models.User;
import com.aviato.demo.repositories.FlightRepository;
import com.aviato.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {


    // Injecting instance //
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;


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

    @GetMapping("/profile/flights")
    public String userFlights(Model model) {

        // Retrieve the logged-in User object from the security context //
        User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Retrieve the list of flights associated with the logged-in User //
        List<Flight> flights = loggedinUser.getFlightsList();

        // Add the list of flights to the model //
        model.addAttribute("flights", flights);

        // Return the "flights" view //
        return "flights";
    }

    @PostMapping("/profile/flights/{flightId}")
    public String cancelFlight(@PathVariable Long flightId) {

        // Retrieve the logged-in User object from the security context //
        User loggedinUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Retrieve the Flight object with the specified ID //
        Flight flight = flightRepository.findById(flightId).orElse(null);

        // Remove the Flight object from the user's list of purchased flights //
        if (flight != null) {
            loggedinUser.getFlightsList().remove(flight);
            userRepository.save(loggedinUser);
        }

        // Redirect back to the "flights" view //
        return "redirect:/profile/flights";
    }




}
