package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Booking;
import com.springframework.hotel.models.Chamber;
import com.springframework.hotel.models.Customer;
import com.springframework.hotel.repositories.BookingRepository;
import com.springframework.hotel.repositories.CategoryRepository;
import com.springframework.hotel.services.IBookingService;
import com.springframework.hotel.services.IChamberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private IChamberService chamberService;

    @Override
    public void addBooking(Customer customer,
                           String expectedArrivalDate,
                           String expectDepartureDate,
                           int numberAudults,
                           int numberChild,
                           int numberRoom,
                           Long chamberId) {
        //Xu ly String do Date
        String convertArrivalDate = expectedArrivalDate.concat(" 12:00:00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime arrivalDate = LocalDateTime.parse(convertArrivalDate, formatter);

        String convertDepartureDate = expectDepartureDate.concat(" 12:00:00");
        LocalDateTime departureDate = LocalDateTime.parse(convertDepartureDate, formatter);
        LocalDateTime time_now = LocalDateTime.now();
        //Luu booking
        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setBookingDate(time_now);
        booking.setExpectedArrivalDate(arrivalDate);
        booking.setExpectDepartureDate(departureDate);
        booking.setNumberAudults(numberAudults);
        booking.setNumberChild(numberChild);
        booking.setNumberRoom(numberRoom);
        Chamber chamber = chamberService.findChamber(chamberId);
        booking.setChamber(chamber);
        bookingRepository.save(booking);
    }
}
