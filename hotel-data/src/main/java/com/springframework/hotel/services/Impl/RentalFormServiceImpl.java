package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.RentalForm;
import com.springframework.hotel.repositories.RentalFormRepository;
import com.springframework.hotel.services.IRentalFormService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalFormServiceImpl implements IRentalFormService {
    private RentalFormRepository rentalFormRepository;

    public RentalFormServiceImpl(RentalFormRepository rentalFormRepository) {
        this.rentalFormRepository = rentalFormRepository;
    }

    @Override
    public List<RentalForm> findAll() {
        List<RentalForm> rentalForms = new ArrayList<>();
        rentalFormRepository.findAll().forEach(rentalForms::add);
        return rentalForms;
    }

    @Override
    public RentalForm findById(Integer integer) {
        Optional<RentalForm> rentalForm = rentalFormRepository.findById(integer);
        return rentalForm.orElse(null);
    }

    @Override
    public RentalForm save(RentalForm object) {
        return rentalFormRepository.save(object);
    }

    @Override
    public void delete(RentalForm object) {
        rentalFormRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        rentalFormRepository.deleteById(integer);
    }
}
