package com.springframework.hotel.repositories;

import com.springframework.hotel.models.RentalForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalFormRepository extends JpaRepository<RentalForm,Integer> {
}
