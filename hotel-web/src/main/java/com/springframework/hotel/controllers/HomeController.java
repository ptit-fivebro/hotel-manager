package com.springframework.hotel.controllers;

import com.springframework.hotel.dto.SearchRoomRequest;
import com.springframework.hotel.services.IChamberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private IChamberService chamberService;

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        model.addAttribute("title", "Trang chủ");
        model.addAttribute("searchRoom", new SearchRoomRequest());
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
