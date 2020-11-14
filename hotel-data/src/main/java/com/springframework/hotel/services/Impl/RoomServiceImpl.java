package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Room;
import com.springframework.hotel.repositories.RoomRepository;
import com.springframework.hotel.services.IRoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements IRoomService {
    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    @Override
    public Room findById(Integer integer) {
        Optional<Room> room = roomRepository.findById(integer);
        return room.orElse(null);
    }

    @Override
    public Room save(Room object) {
        return roomRepository.save(object);
    }

    @Override
    public void delete(Room object) {
        roomRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        roomRepository.deleteById(integer);
    }
}
