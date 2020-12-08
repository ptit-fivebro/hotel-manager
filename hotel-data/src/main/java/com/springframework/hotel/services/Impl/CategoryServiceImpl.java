package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Category;
import com.springframework.hotel.repositories.CategoryRepository;
import com.springframework.hotel.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> loadListCategories() {
        // TODO Auto-generated method stub
        return categoryRepository.findAll();
    }

    @Override
    public Category getOne(Long id) {
        // TODO Auto-generated method stub
        return categoryRepository.getOne(id);
    }
}
