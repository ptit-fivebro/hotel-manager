package com.springframework.hotel.repositories;

import com.springframework.hotel.models.ServiceBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBillRepository extends JpaRepository<ServiceBill, Long>{

}
