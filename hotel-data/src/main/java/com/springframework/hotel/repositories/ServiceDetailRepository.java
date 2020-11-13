package com.springframework.hotel.repositories;

import com.springframework.hotel.models.ServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDetailRepository extends JpaRepository<ServiceDetail,Integer> {
}
