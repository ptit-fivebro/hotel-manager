package com.springframework.hotel.services;

import java.util.List;

import com.springframework.hotel.dto.FoodItemDto;
import com.springframework.hotel.models.FoodItem;
import org.springframework.data.domain.Page;


public interface IFoodItemService {

    List<FoodItem> loadToSelectOption();

    FoodItem getItem(Long id);

    FoodItemDto getFoodItem(Long id);

    Page<FoodItemDto> getListFoodItem(org.springframework.data.domain.Pageable pageable,String text);

    void saveFoodItem(FoodItem item);

    void deleteFoodItem(Long id);
}
