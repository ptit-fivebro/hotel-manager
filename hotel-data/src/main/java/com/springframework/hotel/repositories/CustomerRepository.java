package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
