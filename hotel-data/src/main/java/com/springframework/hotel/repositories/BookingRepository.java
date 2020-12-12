package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Bill;
import com.springframework.hotel.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

//    @Query(CustomQuery.BOOKING_SEARCH_TIME)
//    List<Bill> searchBillWithTime(@Param("expectedArrivalDate") String expectedArrivalDate, @Param("expectDepartureDate") String expectDepartureDate );

}
