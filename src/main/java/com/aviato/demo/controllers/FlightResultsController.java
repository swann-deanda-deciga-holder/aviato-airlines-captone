package com.aviato.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlightResultsController {

    @GetMapping("/results")
    public String showResults() {
        return "results";
    }
}
