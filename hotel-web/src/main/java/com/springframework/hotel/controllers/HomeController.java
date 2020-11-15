package com.springframework.hotel.controllers;

import com.springframework.hotel.models.RoomCategory;
import com.springframework.hotel.services.IRoomCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    private final IRoomCategoryService roomCategoryService;

    public HomeController(IRoomCategoryService roomCategoryService) {
        this.roomCategoryService = roomCategoryService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        //List<RoomCategory> list = roomCategoryService.findAll();s
        //System.out.println(list.size());
        //model.addAttribute("roomCategories", roomCategoryService.findAll());
        return "index";
    }

    @RequestMapping({"404", "404.html"})
    public String notFound(Model model) {
        return "404";
    }

    @RequestMapping({"about", "about.html"})
    public String about(Model model) {
        return "about";
    }

    @RequestMapping({"booking", "booking.html"})
    public String booking(Model model) {
        return "booking";
    }

    @RequestMapping({"contact", "contact.html"})
    public String contact(Model model) {
        return "contact";
    }

    @RequestMapping({"room", "room.html"})
    public String room(Model model) {
        return "room";
    }

    @RequestMapping({"sign-in", "sign-in.html"})
    public String signIn(Model model) {
        return "sign-in";
    }

    @RequestMapping({"sign-up", "sign-up.html"})
    public String signUp(Model model) {
        return "sign-up";
    }

    @RequestMapping({"success", "success.html"})
    public String success(Model model) {
        return "success";
    }
}
