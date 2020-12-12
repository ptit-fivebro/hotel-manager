package com.springframework.hotel.api;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springframework.hotel.dto.CheckInInfoDto;
import com.springframework.hotel.dto.CheckOutDto;
import com.springframework.hotel.models.*;
import com.springframework.hotel.services.IBillService;
import com.springframework.hotel.services.IChamberService;
import com.springframework.hotel.services.IGuestService;
import com.springframework.hotel.services.IRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckOutApi {

    @Autowired
    private IBillService billService;

    @Autowired
    private IChamberService chamberService;

    @Autowired
    private IRentalService rentalService;

    // rollback khi gap bat ki ngoai le nao CHUA DC xu ly
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/rent-chamber-complete")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody CheckOutDto checkout, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();
        if (errors.hasErrors()) {
            result.setMessage(
                    errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        chamberService.updateCheckOut(Long.parseLong(checkout.getChamberId())); // doi trang thai phong thanh không có nguoi o
        Chamber chamber = chamberService.findChamber(Long.parseLong(checkout.getChamberId())); // tim phong da thay doi t.thai o tren

        Rental rental = rentalService.getRentalById(Long.parseLong(checkout.getRentalId()));
        Set<Chamber> chambers = new HashSet<Chamber>();
        Date date = new Date();
        chambers.add(chamber);
        rental.setChambers(chambers);
        rental.setCheckOutDate(date); // set ngay check out la ngay hom nay
        rental.setPaid("true"); // khach da tra tien
        rentalService.addRentalInfo(rental); // them hoa don thue phong

        Bill bill = new Bill();
        bill.setDate(date);
        bill.setTotalFood(Double.parseDouble(checkout.getFood()));
        bill.setTotalRent(Double.parseDouble(checkout.getRent()));
        bill.setTotalService(Double.parseDouble(checkout.getService()));
        bill.setTotalPay(Double.parseDouble(checkout.getTotal()));
        bill.setRental(rental);
        billService.addBillInfo(bill);

        result.setMessage("Check out thành công!");
        return ResponseEntity.ok(result);

    }
}
