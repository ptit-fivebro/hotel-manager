package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Integer> {
}
