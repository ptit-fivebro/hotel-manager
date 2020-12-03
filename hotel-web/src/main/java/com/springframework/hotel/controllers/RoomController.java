package com.springframework.hotel.controllers;

import com.springframework.hotel.models.RoomCategory;
import com.springframework.hotel.services.IRoomCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class RoomController {
    private final IRoomCategoryService roomCategoryService;

    public RoomController(IRoomCategoryService roomCategoryService) {
        this.roomCategoryService = roomCategoryService;
    }

    @RequestMapping(value = "/room/", method = RequestMethod.GET)
    public String singleListing(ModelMap model, @RequestParam("id") String id) throws IOException {
        RoomCategory roomCategory = roomCategoryService.findById(id);
        model.addAttribute("room", roomCategory);
        return "room-detail";
    }
}
