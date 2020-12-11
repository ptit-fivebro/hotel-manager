package com.springframework.hotel.services;

import com.springframework.hotel.dto.CustomerDTO;
import com.springframework.hotel.models.Customer;

import java.util.Optional;

public interface ICustomerService {

    void register(Customer customer);

    Optional<CustomerDTO> login(String email, String password);
}
