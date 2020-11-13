package com.springframework.hotel.repositories;

import com.springframework.hotel.models.BookingFormStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingFormStatusRepository extends JpaRepository<BookingFormStatus,Integer> {
}
