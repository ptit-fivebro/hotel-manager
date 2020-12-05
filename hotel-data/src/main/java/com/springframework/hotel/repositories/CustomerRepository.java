package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByEmailAndPassword(String email, String password);
}
