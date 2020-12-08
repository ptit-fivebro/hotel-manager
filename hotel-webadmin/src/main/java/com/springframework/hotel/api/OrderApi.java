package com.springframework.hotel.api;

import com.springframework.hotel.dto.OrderFoodDto;
import com.springframework.hotel.dto.OrderServiceDto;
import com.springframework.hotel.models.AjaxResponseBody;
import com.springframework.hotel.models.OrderFood;
import com.springframework.hotel.models.Rental;
import com.springframework.hotel.models.ServiceBill;
import com.springframework.hotel.services.IOrderFoodService;
import com.springframework.hotel.services.IRentalService;
import com.springframework.hotel.services.IServiceBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;


@RestController
public class OrderApi {

    @Autowired
    private IOrderFoodService orderFoodService;

    @Autowired
    private IServiceBillService serviceBillService;

    @Autowired
    private IRentalService rentalService;

    @Transactional(rollbackFor = Exception.class) // update data
    @PostMapping("/order/order-food")
    public ResponseEntity<?> addOrderFood(@Valid @RequestBody OrderFoodDto order, Errors error) {

        AjaxResponseBody result = new AjaxResponseBody();
        if (error.hasErrors()) {
            result.setMessage(
                    error.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }

        Rental rental = rentalService.getRentalById(order.getRentalId());
        OrderFood orderFood = new OrderFood(order.getTotalPrice(), order.getPeopleNumber(), order.getOrderDate(),
                order.getDiscount(), order.getNote(), rental);

        orderFoodService.addOrderFood(orderFood);

        result.setMessage("Lưu thành công!");
        return ResponseEntity.ok(result);
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/order/order-service")
    public ResponseEntity<?> addOrderService(@Valid @RequestBody OrderServiceDto order, Errors error) {

        AjaxResponseBody result = new AjaxResponseBody();
        if (error.hasErrors()) {
            result.setMessage(
                    error.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }

        Rental rental = rentalService.getRentalById(order.getRentalId());
        ServiceBill bill = new ServiceBill(order.getTotalPrice(), order.getOrderDate(), order.getDiscount(),
                order.getNote(), rental);
        serviceBillService.addServiceBill(bill);

        result.setMessage("Lưu thành công!");
        return ResponseEntity.ok(result);
    }
}

