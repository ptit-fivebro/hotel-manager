package com.springframework.hotel.repositories;

import com.springframework.hotel.models.BookingFormDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingFormDetailRepository extends JpaRepository<BookingFormDetail,Integer> {
}
