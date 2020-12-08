package com.springframework.hotel.repositories;

import java.util.List;

import com.springframework.hotel.models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{

    @Query(CustomQuery.MULTIPLE_GET_FOOD_ITEM_INFO)
    List<Object[]> getListFoodItem(@Param("text") String text);

    @Query(CustomQuery.MULTIPLE_GET_ONE_FOOD_ITEM_INFO)
    Object[] getOneFoodItem(@Param("id") long id);
}
