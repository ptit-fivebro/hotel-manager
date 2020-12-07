package com.springframework.hotel.controllers;

import com.springframework.hotel.services.IRoomCategoryService;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {
    private final IRoomCategoryService roomCategoryService;

    public RoomController(IRoomCategoryService roomCategoryService) {
        this.roomCategoryService = roomCategoryService;
    }

}
