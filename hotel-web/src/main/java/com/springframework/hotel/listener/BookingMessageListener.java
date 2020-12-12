package com.springframework.hotel.listener;

import com.google.gson.Gson;
import com.springframework.hotel.models.Booking;
import com.springframework.hotel.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BookingMessageListener {

    @Autowired
    private BookingRepository bookingRepository;

    @JmsListener(destination = "inbound.queue")
    @SendTo("outbound.queue")
    public void receiveMessage(Map<String, Booking> message) {
        System.out.println("Received <" + message + ">");
        //parse json
        Gson gson = new Gson();
        Booking temp = gson.fromJson(String.valueOf(message.get("booking")), Booking.class);
        Booking booking = new Booking();
        booking.setBookingDate(temp.getBookingDate());
        booking.setExpectedArrivalDate(temp.getExpectedArrivalDate());
        booking.setExpectDepartureDate(temp.getExpectDepartureDate());
        booking.setNumberAudults(temp.getNumberAudults());
        booking.setNumberChild(temp.getNumberChild());
        booking.setNumberRoom(temp.getNumberRoom());
        booking.setChamber(temp.getChamber());
        booking.setCustomer(temp.getCustomer());
        bookingRepository.save(booking);
        System.out.println("Message processed...");
    }
}
