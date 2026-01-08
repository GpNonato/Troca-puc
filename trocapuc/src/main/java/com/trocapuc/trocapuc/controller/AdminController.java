package com.trocapuc.trocapuc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

    @GetMapping("/admin")
    public String showAdmin(Model model) {
        return "admin";
    }
    
    
}


