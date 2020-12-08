package com.springframework.hotel.services.Impl;
import java.util.List;

import com.springframework.hotel.models.Chamber;
import com.springframework.hotel.models.Guest;
import com.springframework.hotel.models.Rental;
import com.springframework.hotel.repositories.RentalRepository;
import com.springframework.hotel.services.IRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl implements IRentalService {

    @Autowired
    private RentalRepository rentalRepository;


    @Override
    public void addRentalInfo(Rental rental) {
        // TODO Auto-generated method stub
        rentalRepository.save(rental);
    }

    @Override
    public List<String> getListChamberOrderFood() {
        // TODO Auto-generated method stub
        return rentalRepository.getListChamberOrderFood();
    }

    @Override
    public String getRentalIdOrderFood(String chamberNumber) {
        // TODO Auto-generated method stub
        return rentalRepository.getRentalIdOrderFood(chamberNumber);
    }

    @Override
    public Rental getRentalById(Long id) {
        // TODO Auto-generated method stub
        return rentalRepository.getOne(id);
    }

    @Override
    public Integer getCheckTotalFoodPrice(String chamberId) {
        // TODO Auto-generated method stub
        return rentalRepository.getCheckTotalFoodPrice(chamberId);
    }

    @Override
    public Integer getCheckTotalServicePrice(String chamberId) {
        // TODO Auto-generated method stub
        return rentalRepository.getCheckTotalServicePrice(chamberId);
    }

    @Override
    public Integer getNumberDaysStay(String chamberId) {
        // TODO Auto-generated method stub
        return rentalRepository.getNumberDaysStay(chamberId);
    }

    @Override
    public Rental getRentalCheckOutInfo(String chamberNumber) {
        // TODO Auto-generated method stub
        return rentalRepository.getRentalCheckOutInfo(chamberNumber);
    }

    @Override
    public Guest getGuestCheckOutInfo(String chamberNumber) {
        // TODO Auto-generated method stub
        return rentalRepository.getGuestCheckOutInfo(chamberNumber);
    }

    @Override
    public Chamber getChamberCheckOutInfo(String chamberNumber) {
        // TODO Auto-generated method stub
        return rentalRepository.getChamberCheckOutInfo(chamberNumber);
    }

}
