package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.OrderFood;
import com.springframework.hotel.repositories.OrderFoodRepository;
import com.springframework.hotel.services.IOrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFoodServiceImpl implements IOrderFoodService {

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    @Override
    public void addOrderFood(OrderFood orderFood) {
        orderFoodRepository.save(orderFood);
    }

}
