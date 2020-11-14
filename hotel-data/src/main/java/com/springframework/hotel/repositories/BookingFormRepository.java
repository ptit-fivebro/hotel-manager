package com.springframework.hotel.repositories;

import com.springframework.hotel.models.BookingForm;
import org.springframework.data.jpa.repository.JpaRepository;
 public interface BookingFormRepository extends JpaRepository<BookingForm,Integer> {
}
