package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
