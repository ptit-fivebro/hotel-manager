package com.springframework.hotel.services.Impl;

import com.springframework.hotel.dto.CustomerDTO;
import com.springframework.hotel.models.Customer;
import com.springframework.hotel.repositories.CustomerRepository;
import com.springframework.hotel.services.ICustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private CustomerRepository customerRepository;
    private CustomerDTO user;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer findById(Integer integer) {
        Optional<Customer> customer = customerRepository.findById(integer);
        return customer.orElse(null);
    }

    @Override
    public Customer save(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public void delete(Customer object) {
        customerRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        customerRepository.deleteById(integer);
    }

    @Override
    public Optional<CustomerDTO> register(Customer customer) {
        return null;
    }

    @Override
    public Optional<CustomerDTO> login(String email, String password) {
        if (StringUtils.isAnyBlank(email, password)) {
            return Optional.empty();
        }
        Optional<CustomerDTO> usersDTO = customerRepository.findByEmailAndPassword(email, password)
                .map(users -> {
                    CustomerDTO dto = new CustomerDTO();
                    BeanUtils.copyProperties(users, dto);
                    return dto;
                });
        user = usersDTO.orElse(null);
        return Optional.ofNullable(user);
    }
}
