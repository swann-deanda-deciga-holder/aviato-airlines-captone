//package com.aviato.demo.controllers;
//
//import com.aviato.demo.models.Flight;
//import com.aviato.demo.repositories.FlightRepository;
//import com.aviato.demo.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class FlightInfoController {
//    // Injecting UserRepo //
//    @Autowired
//    private FlightRepository flightRepository;
//
//    @GetMapping("/flight-info")
//    public String showFlightInfoForm(Model model) {
//        model.addAttribute("flight", new Flight());
//        return "flightTesting";
//    }
//
//    @PostMapping("/flight-info")
//    public String submitFlightInfoForm(@ModelAttribute("flight") Flight flight) {
//
//        return "redirect:/profile";
//    }
//}
//
//
//
