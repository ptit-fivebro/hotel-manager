package com.springframework.hotel.controllers;

import com.springframework.dto.SearchRoomRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        model.addAttribute("title", "Trang chủ");
        model.addAttribute("searchRoom", new SearchRoomRequest());
        return "index";
    }

    @RequestMapping(value = "/seachRoom", method = RequestMethod.GET)
    public String search(Model model, @ModelAttribute("searchRoom") SearchRoomRequest searchRequest) {
        System.out.println(searchRequest);
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
