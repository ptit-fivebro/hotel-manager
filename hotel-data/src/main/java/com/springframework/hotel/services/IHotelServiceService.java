package com.springframework.hotel.services;

import com.springframework.hotel.models.HotelService;

import java.util.List;

public interface IHotelServiceService {

    List<HotelService> loadHotel();

    HotelService getService(Long id);

    void saveService(HotelService service);

    void deleteService(Long id);
}
