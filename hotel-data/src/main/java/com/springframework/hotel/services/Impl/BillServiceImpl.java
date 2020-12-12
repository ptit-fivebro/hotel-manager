package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Bill;
import com.springframework.hotel.repositories.BillRepository;
import com.springframework.hotel.repositories.RentalRepository;
import com.springframework.hotel.services.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public void addBillInfo(Bill bill) {
        billRepository.save(bill);
    }
}
