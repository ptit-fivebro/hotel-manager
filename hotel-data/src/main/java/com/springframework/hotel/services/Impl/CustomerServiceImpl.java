package com.springframework.hotel.services.Impl;

import com.springframework.hotel.dto.CustomerDTO;
import com.springframework.hotel.models.Customer;
import com.springframework.hotel.repositories.CustomerRepository;
import com.springframework.hotel.services.ICustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void register(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> login(String email, String password) {
        if (StringUtils.isAnyBlank(email, password)) {
            return Optional.empty();
        }
        Optional<Customer> customer = customerRepository.findByEmailAndPassword(email, password);
        return customer;
    }
}
