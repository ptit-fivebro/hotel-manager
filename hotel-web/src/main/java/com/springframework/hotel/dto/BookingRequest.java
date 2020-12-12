package com.springframework.hotel.dto;

import lombok.Data;

@Data
public class BookingRequest {

    private String name;

    private String email;

    private String phone;

    private String expectedArrivalDate;

    private String expectDepartureDate;

    private int numberAudults;

    private int numberChild;

    private int numberRoom;

    private int roomCategory;
}
