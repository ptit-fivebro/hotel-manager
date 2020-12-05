package com.springframework.hotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"admin"})
public class HomeController {
    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        return "index";
    }
}
