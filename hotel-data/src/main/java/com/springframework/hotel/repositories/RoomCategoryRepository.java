package com.springframework.hotel.repositories;

import com.springframework.hotel.models.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Integer> {
}
