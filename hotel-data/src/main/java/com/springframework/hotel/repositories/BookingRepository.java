package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
