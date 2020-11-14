package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part,String> {
}
