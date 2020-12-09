package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.ServiceBill;
import com.springframework.hotel.repositories.ServiceBillRepository;
import com.springframework.hotel.services.IServiceBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBillServiceImpl implements IServiceBillService {

    @Autowired
    private ServiceBillRepository serviceBillRepository;

    @Override
    public void addServiceBill(ServiceBill bill) {
        serviceBillRepository.save(bill);
    }

}
