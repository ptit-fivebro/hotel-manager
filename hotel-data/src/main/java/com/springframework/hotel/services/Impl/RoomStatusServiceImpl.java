package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.RoomStatus;
import com.springframework.hotel.repositories.RoomStatusRepository;
import com.springframework.hotel.services.IRoomStatusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomStatusServiceImpl implements IRoomStatusService {
    private RoomStatusRepository roomStatusRepository;

    public RoomStatusServiceImpl(RoomStatusRepository roomStatusRepository) {
        this.roomStatusRepository = roomStatusRepository;
    }

    @Override
    public List<RoomStatus> findAll() {
        List<RoomStatus> roomStatuses = new ArrayList<>();
        roomStatusRepository.findAll().forEach(roomStatuses::add);
        return roomStatuses;
    }

    @Override
    public RoomStatus findById(Integer integer) {
        Optional<RoomStatus> roomStatus = roomStatusRepository.findById(integer);
        return roomStatus.orElse(null);
    }

    @Override
    public RoomStatus save(RoomStatus object) {
        return roomStatusRepository.save(object);
    }

    @Override
    public void delete(RoomStatus object) {
        roomStatusRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        roomStatusRepository.deleteById(integer);
    }
}
