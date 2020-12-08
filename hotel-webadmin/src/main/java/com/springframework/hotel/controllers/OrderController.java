package com.springframework.hotel.controllers;

import com.springframework.hotel.dto.GuestOrderFoodDto;
import com.springframework.hotel.dto.MenuOrderFoodDto;
import com.springframework.hotel.dto.MenuOrderServiceDto;
import com.springframework.hotel.models.AjaxResponseBody;
import com.springframework.hotel.models.FoodItem;
import com.springframework.hotel.models.Guest;
import com.springframework.hotel.models.HotelService;
import com.springframework.hotel.services.IFoodItemService;
import com.springframework.hotel.services.IGuestService;
import com.springframework.hotel.services.IHotelServiceService;
import com.springframework.hotel.services.IRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private IRentalService rentalService;

    @Autowired
    private IGuestService guestService;

    @Autowired
    private IFoodItemService foodItemService;

    @Autowired
    private IHotelServiceService hotelServiceService;

    @GetMapping("/order")
    public String showOrder(Model model) {
        model.addAttribute("list_chambers", rentalService.getListChamberOrderFood());
        model.addAttribute("list_foods", foodItemService.loadToSelectOption());
        model.addAttribute("list_services", hotelServiceService.loadHotel());
        return "order";
    }

    @GetMapping("/order/find-guest")
    @ResponseBody
    public GuestOrderFoodDto findGuestByChamberNumber(@RequestParam(name = "number") String chamberNumber) {
        Guest guest = guestService.getGuestInfoByChamberNumber(chamberNumber);
        String rentalId = rentalService.getRentalIdOrderFood(chamberNumber);
        GuestOrderFoodDto guestDto = new GuestOrderFoodDto(guest, rentalId);
        return guestDto;
    }

    @GetMapping("/order/add-menu")
    @ResponseBody
    public MenuOrderFoodDto addMenuFood(@RequestParam(name = "id", defaultValue = "0") Long id,
                                        @RequestParam(name = "q", defaultValue = "0") int quantity) {
        FoodItem foodItem = foodItemService.getItem(id);
        MenuOrderFoodDto menu = new MenuOrderFoodDto(foodItem, quantity);
        return menu;
    }

    @GetMapping("/order/add-service")
    @ResponseBody
    public MenuOrderServiceDto addService(@RequestParam(name = "id", defaultValue = "0") Long id,
                                          @RequestParam(name = "q", defaultValue = "0") String quantity) {
        HotelService service = hotelServiceService.getService(id);
        MenuOrderServiceDto oService = new MenuOrderServiceDto(service, quantity);
        return oService;
    }

    @GetMapping("/order/service-price")
    @ResponseBody
    public AjaxResponseBody getServicePrice(@RequestParam(name = "id", defaultValue = "0") Long id) {
        HotelService service = hotelServiceService.getService(id);
        String result = null;
        if (service.getPrice().equalsIgnoreCase("0")) {
            result = "0";
        } else {
            result = service.getPrice() + "/" + service.getUnit();
        }
        return new AjaxResponseBody(result);
    }
}
