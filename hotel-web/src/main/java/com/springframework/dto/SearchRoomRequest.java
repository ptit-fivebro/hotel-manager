package com.springframework.dto;

import lombok.Data;

@Data
public class SearchRoomRequest {

    private String expectedArrivalDate;

    private String expectDepartureDate;

    private int numberAudults;

    private int numberChild;

    private int numberRoom;

    private String roomCategory;
}
