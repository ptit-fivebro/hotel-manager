package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Booking;
import com.springframework.hotel.repositories.BookingRepository;
import com.springframework.hotel.repositories.CategoryRepository;
import com.springframework.hotel.services.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }
}
