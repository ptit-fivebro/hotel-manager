package com.springframework.hotel.repositories;

import com.springframework.hotel.models.RentalFormDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalFormDetailRepository extends JpaRepository<RentalFormDetail,Integer> {
}
