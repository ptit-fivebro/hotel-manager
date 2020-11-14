package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.RentalFormDetail;
import com.springframework.hotel.repositories.RentalFormDetailRepository;
import com.springframework.hotel.services.RentalFormDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalFormDetailServiceImpl implements RentalFormDetailService {
    private RentalFormDetailRepository rentalFormDetailRepository;

    public RentalFormDetailServiceImpl(RentalFormDetailRepository rentalFormDetailRepository) {
        this.rentalFormDetailRepository = rentalFormDetailRepository;
    }

    @Override
    public List<RentalFormDetail> findAll() {
        List<RentalFormDetail> rentalFormDetails = new ArrayList<>();
        rentalFormDetailRepository.findAll().forEach(rentalFormDetails::add);
        return rentalFormDetails;
    }

    @Override
    public RentalFormDetail findById(Integer integer) {
        Optional<RentalFormDetail> rentalFormDetail = rentalFormDetailRepository.findById(integer);
        return rentalFormDetail.orElse(null);
    }

    @Override
    public RentalFormDetail save(RentalFormDetail object) {
        return rentalFormDetailRepository.save(object);
    }

    @Override
    public void delete(RentalFormDetail object) {
        rentalFormDetailRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        rentalFormDetailRepository.deleteById(integer);
    }
}
