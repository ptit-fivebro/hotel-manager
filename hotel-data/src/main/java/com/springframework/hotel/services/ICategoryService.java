package com.springframework.hotel.services;

import com.springframework.hotel.models.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> loadListCategories();

    Category getOne(Long id);

}
