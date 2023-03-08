package com.aviato.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String showTestPage(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "test";
    }
}
