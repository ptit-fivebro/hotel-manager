package com.springframework.hotel.repositories;

import com.springframework.hotel.models.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory,Integer> {
}
