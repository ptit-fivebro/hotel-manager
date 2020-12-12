package com.springframework.hotel.services;

import com.springframework.hotel.models.Customer;

public interface IBookingService {
    void addBooking(Customer customer,
                    String expectedArrivalDate,
                    String expectDepartureDate,
                    int numberAudults,
                    int numberChild,
                    int numberRoom,
                    Long chamberId);
}
