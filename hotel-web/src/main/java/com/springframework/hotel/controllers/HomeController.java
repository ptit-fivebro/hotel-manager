package com.springframework.hotel.controllers;

import com.springframework.hotel.services.IRoomCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final IRoomCategoryService roomCategoryService;

    public HomeController(IRoomCategoryService roomCategoryService) {
        this.roomCategoryService = roomCategoryService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        model.addAttribute("title", "Trang chủ");
        model.addAttribute("roomCategories", roomCategoryService.findAll());
        return "index";
    }

    @RequestMapping({"404", "404.html"})
    public String notFound(Model model) {
        return "404";
    }

    @RequestMapping({"about-us", "about-us.html"})
    public String about(Model model) {
        return "about-us";
    }

    @RequestMapping({"contact", "contact.html"})
    public String contact(Model model) {
        return "contact";
    }

    @RequestMapping({"rooms", "rooms.html"})
    public String room(Model model) {
        return "rooms";
    }

    @RequestMapping({"services", "services.html"})
    public String services(Model model) {
        return "services";
    }

    @RequestMapping({"success", "success.html"})
    public String success(Model model) {
        return "success";
    }

    @RequestMapping({"successRegister", "successRegister.html"})
    public String successRegister(Model model) {
        model.addAttribute("title", "Đăng ký thành công");
        return "successRegister";
    }
}
