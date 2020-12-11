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

    private CustomerDTO user;

    @Override
    public void register(Customer customer) {
        customerRepository.save(customer);
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
