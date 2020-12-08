package com.springframework.hotel.services;

import com.springframework.hotel.models.Chamber;
import com.springframework.hotel.models.Guest;
import com.springframework.hotel.models.Rental;

import java.util.List;

public interface IRentalService {

    void addRentalInfo(Rental rental);

    List<String> getListChamberOrderFood();

    String getRentalIdOrderFood(String chamberNumber);

    Rental getRentalById(Long id);

    Rental getRentalCheckOutInfo(String chamberNumber );

    Guest getGuestCheckOutInfo(String chamberNumber);

    Chamber getChamberCheckOutInfo(String chamberNumbe);

    Integer getCheckTotalFoodPrice(String chamberNumber);

    Integer getCheckTotalServicePrice(String chamberNumber);

    Integer getNumberDaysStay(String chamberNumber);
}
