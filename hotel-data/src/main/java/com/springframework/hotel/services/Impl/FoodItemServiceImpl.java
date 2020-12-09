package com.springframework.hotel.services.Impl;

import java.util.ArrayList;
import java.util.List;

import com.springframework.hotel.dto.FoodItemDto;
import com.springframework.hotel.models.FoodItem;
import com.springframework.hotel.repositories.FoodItemRepository;
import com.springframework.hotel.services.IFoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
public class FoodItemServiceImpl implements IFoodItemService {

    @Autowired
    public FoodItemRepository foodItemRepository;

    @Override
    public List<FoodItem> loadToSelectOption() {
        return foodItemRepository.findAll();
    }

    @Override
    public FoodItem getItem(Long id) {
        return foodItemRepository.findById(id).get();
    }

    @Override
    public Page<FoodItemDto> getListFoodItem(org.springframework.data.domain.Pageable pageable,String text) {
        List<Object[]> foodItem = foodItemRepository.getListFoodItem("%"+text+"%");
        List<FoodItemDto> result = new ArrayList<FoodItemDto>();
        for(Object[] item:foodItem) {
            result.add(new FoodItemDto(item));
        }
        int start = (int)pageable.getOffset();
        int end = (int) ((pageable.getOffset() + pageable.getPageSize()) > result.size()?
                result.size():pageable.getOffset() + pageable.getPageSize());
        List<FoodItemDto> subList = result.subList(start, end);
        return new PageImpl<FoodItemDto>(subList, pageable, result.size());

    }

    @Override
    public FoodItemDto getFoodItem(Long id) {
        Object[] item = foodItemRepository.getOneFoodItem(id);
        FoodItemDto result = new FoodItemDto(item);
        return result;
    }

    @Override
    public void saveFoodItem(FoodItem item) {
        foodItemRepository.save(item);
    }

    @Override
    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }
}

