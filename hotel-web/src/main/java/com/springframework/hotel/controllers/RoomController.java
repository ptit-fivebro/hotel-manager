package com.springframework.hotel.controllers;

import com.springframework.hotel.dto.BookingRequest;
import com.springframework.hotel.dto.LoginRequest;
import com.springframework.hotel.dto.SearchRoomRequest;
import com.springframework.hotel.services.IChamberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class RoomController {

    @Autowired
    private IChamberService chamberService;

    @Autowired
    private HttpSession session;

    @RequestMapping({"rooms", "rooms.html"})
    public String room(Model model) {
        model.addAttribute("title", "Danh sách phòng");
        model.addAttribute("rooms", chamberService.findAllChamber());
        return "rooms";
    }

    @RequestMapping(value = "/seachRoom", method = RequestMethod.GET)
    public String search(Model model, @ModelAttribute("searchRoom") SearchRoomRequest searchRequest) {
        model.addAttribute("title", "Danh sách phòng");
        if(session.getAttribute("usersession") == null){
            model.addAttribute("loginRequest", new LoginRequest());
            return "login";
        }
        model.addAttribute("rooms", chamberService.searchRoom(searchRequest.getExpectedArrivalDate(),
                searchRequest.getExpectDepartureDate(),
                searchRequest.getNumberAudults(),
                searchRequest.getNumberChild(),
                searchRequest.getNumberRoom(),
                searchRequest.getRoomCategory()));
        session.setAttribute("searchRoomSession", searchRequest);
        return "booking";

    }

    @RequestMapping(value = "/bookingRoom", method = RequestMethod.GET)
    public String booking(Model model) {
        model.addAttribute("title", "Đặt phòng");
        model.addAttribute("bookingRequest", new BookingRequest());
        session.getAttribute("usersession");
        session.getAttribute("searchRoomSession");
        return "success";
    }

    @PostMapping(value = "/bookingRoom")
    public String bookingRoom(Model model) {
        model.addAttribute("title", "Đặt phòng");
        session.getAttribute("searchRoomSession");
        return "success";
    }
}
