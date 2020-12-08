package com.springframework.hotel.services.Impl;


import java.util.List;

import com.springframework.hotel.models.HotelService;
import com.springframework.hotel.repositories.HotelServiceRepository;
import com.springframework.hotel.services.IHotelServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceServiceImpl implements IHotelServiceService {

    @Autowired
    private HotelServiceRepository hotelServiceRepository;

    @Override
    public List<HotelService> loadHotel() {
        // TODO Auto-generated method stub
        return hotelServiceRepository.findAll();
    }

    @Override
    public HotelService getService(Long id) {
        // TODO Auto-generated method stub
        return hotelServiceRepository.getOne(id);
    }

    @Override
    public void saveService(HotelService service) {
        // TODO Auto-generated method stub
        hotelServiceRepository.save(service);
    }

    @Override
    public void deleteService(Long id) {
        // TODO Auto-generated method stub
        hotelServiceRepository.deleteById(id);
    }
}
