package com.springframework.hotel.repositories;

import com.springframework.hotel.models.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderFoodRepository extends JpaRepository<OrderFood, Long>{

}
