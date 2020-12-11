package com.springframework.hotel.api;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.springframework.hotel.dto.CheckInInfoDto;
import com.springframework.hotel.dto.CheckOutDto;
import com.springframework.hotel.models.AjaxResponseBody;
import com.springframework.hotel.models.Chamber;
import com.springframework.hotel.models.Guest;
import com.springframework.hotel.models.Rental;
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
    private IGuestService guestService;

    @Autowired
    private IChamberService chamberService;

    @Autowired
    private IRentalService rentalService;

    // rollback khi gap bat ki ngoai le nao CHUA DC xu ly
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/rent-chamber-complete")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody CheckOutDto checkout, Errors errors) {
        System.out.println(checkout.getType());
        System.out.println(checkout.getChamberId());
        AjaxResponseBody result = new AjaxResponseBody();
        if (errors.hasErrors()) {
            result.setMessage(
                    errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }

        chamberService.updateCheckOut(Long.parseLong(checkout.getChamberId())); // doi trang thai phong thanh không có nguoi o

        Rental rental = rentalService.getRentalById(Long.parseLong(checkout.getRentalId()));

        Date date = new Date();
        rental.setCheckOutDate(date); // set ngay check out la ngay hom nay
        rental.setPaid("true"); // khach da tra tien
        rentalService.addRentalInfo(rental); // them hoa don thue phong

        result.setMessage("Check out thành công!");
        return ResponseEntity.ok(result);

    }
}
