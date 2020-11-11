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
        List<RoomCategory> list = roomCategoryService.findAll();
        System.out.println(list.size());
        model.addAttribute("roomCategories", roomCategoryService.findAll());
        return "index";
    }
}
