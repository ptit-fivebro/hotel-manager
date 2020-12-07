package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.RoomCategory;
import com.springframework.hotel.repositories.RoomCategoryRepository;
import com.springframework.hotel.services.IRoomCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomCategoryServiceImpl implements IRoomCategoryService {

    private final RoomCategoryRepository roomCategoryRepository;

    public RoomCategoryServiceImpl(RoomCategoryRepository roomCategoryRepository) {
        this.roomCategoryRepository = roomCategoryRepository;
    }

    @Override
    public List<RoomCategory> findAll() {
        List<RoomCategory> roomCategories = new ArrayList<>();
        roomCategoryRepository.findAll().forEach(roomCategories::add);
        return roomCategories;
    }

    @Override
    public RoomCategory findById(Integer id) {
        Optional<RoomCategory> roomCategory = roomCategoryRepository.findById(id);
        return roomCategory.orElse(null);
    }

    @Override
    public RoomCategory save(RoomCategory object) {
        return roomCategoryRepository.save(object);
    }

    @Override
    public void delete(RoomCategory object) {
        roomCategoryRepository.delete(object);
    }

    @Override
    public void deleteById(Integer s) {
        roomCategoryRepository.deleteById(s);
    }
}
