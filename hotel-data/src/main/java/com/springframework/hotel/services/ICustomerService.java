package com.springframework.hotel.services;

import com.springframework.hotel.dto.CustomerDTO;
import com.springframework.hotel.models.Customer;

import java.util.Optional;

public interface ICustomerService extends ICrudService<Customer,Integer> {

    public Optional<CustomerDTO> register(Customer customer);

    public Optional<CustomerDTO> login(String email, String password);
}
