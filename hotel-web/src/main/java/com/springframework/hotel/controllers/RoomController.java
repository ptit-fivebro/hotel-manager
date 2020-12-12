package com.springframework.hotel.controllers;

import com.springframework.hotel.dto.BookingRequest;
import com.springframework.hotel.dto.CustomerDTO;
import com.springframework.hotel.dto.LoginRequest;
import com.springframework.hotel.dto.SearchRoomRequest;
import com.springframework.hotel.models.Bill;
import com.springframework.hotel.models.Booking;
import com.springframework.hotel.models.Chamber;
import com.springframework.hotel.models.Customer;
import com.springframework.hotel.services.IBookingService;
import com.springframework.hotel.services.IChamberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class RoomController {

    @Autowired
    private IChamberService chamberService;

    @Autowired
    private IBookingService bookingService;

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
        model.addAttribute("rooms", chamberService.searchRoom(searchRequest.getExpectedArrivalDate(),
                searchRequest.getExpectDepartureDate(),
                searchRequest.getNumberAudults(),
                searchRequest.getNumberChild(),
                searchRequest.getNumberRoom(),
                searchRequest.getRoomCategory()));
        session.setAttribute("searchRoomSession", searchRequest);
        return "rooms";
    }

    @RequestMapping(value = "/bookingRoom", method = RequestMethod.GET)
    public String booking(Model model, @RequestParam("id") Long idChamber) {
        model.addAttribute("title", "Đặt phòng");
        if(session.getAttribute("usersession") == null){
            model.addAttribute("loginRequest", new LoginRequest());
            return "login";
        }
        model.addAttribute("bookingRequest", new BookingRequest());
        session.getAttribute("usersession");
        session.getAttribute("searchRoomSession");
        session.setAttribute("idChamber", idChamber);
        Chamber chamber = chamberService.findChamber(idChamber);
        model.addAttribute("chamber",chamber);
        return "booking";
    }

    @PostMapping(value = "/bookingRoom")
    public String bookingRoom(Model model) {
        Customer customer = (Customer) session.getAttribute("usersession");
        SearchRoomRequest searchRoom = (SearchRoomRequest) session.getAttribute("searchRoomSession");
        Long idChamber = (Long) session.getAttribute("idChamber");
        bookingService.addBooking(customer,
                searchRoom.getExpectedArrivalDate(),
                searchRoom.getExpectDepartureDate(),
                searchRoom.getNumberAudults(),
                searchRoom.getNumberChild(),
                searchRoom.getNumberRoom(),
                idChamber);
        return "success";
    }
}
