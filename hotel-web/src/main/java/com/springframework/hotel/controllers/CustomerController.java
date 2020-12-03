package com.springframework.hotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    @RequestMapping({"login", "login.html"})
    public String login(Model model) {
        return "login";
    }

    @RequestMapping({"register", "register.html"})
    public String register(Model model) {
        return "register";
    }
}
