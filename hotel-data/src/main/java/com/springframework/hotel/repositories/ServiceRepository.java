package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
