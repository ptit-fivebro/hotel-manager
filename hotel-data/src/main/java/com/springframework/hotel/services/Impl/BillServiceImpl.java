package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Bill;
import com.springframework.hotel.repositories.BillRepository;
import com.springframework.hotel.services.IBillService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements IBillService {
    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> findAll() {
        List<Bill> bills = new ArrayList<>();
        billRepository.findAll().forEach(bills::add);
        return bills;
    }

    @Override
    public Bill findById(Integer integer) {
        Optional<Bill>bill=billRepository.findById(integer);
        return bill.orElse(null);
    }

    @Override
    public Bill save(Bill object) {
        return billRepository.save(object);
    }

    @Override
    public void delete(Bill object) {
        billRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        billRepository.deleteById(integer);
    }
}
