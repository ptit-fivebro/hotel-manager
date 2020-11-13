package com.springframework.hotel.repositories;

import com.springframework.hotel.models.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomStatusRepository extends JpaRepository<RoomStatus,Integer> {
}
