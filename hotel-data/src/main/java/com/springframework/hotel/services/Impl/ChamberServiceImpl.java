package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Bill;
import com.springframework.hotel.models.Chamber;
import com.springframework.hotel.repositories.BookingRepository;
import com.springframework.hotel.repositories.ChamberRepository;
import com.springframework.hotel.services.IChamberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChamberServiceImpl implements IChamberService {

    @Autowired
    private ChamberRepository chamberRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Chamber findChamber(Long id) {
        return chamberRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteChamber(Long chamberId) {
        chamberRepository.deleteById(chamberId);
    }

    @Override
    public Page<Chamber> searchChamberWithPrice1(Pageable pageable,String type, String vip) {
        return chamberRepository.searchChamberWithPrice1(pageable,type, vip);
    }

    @Override
    public Page<Chamber> searchChamberWithPrice2(Pageable pageable,String type, String vip) {
        return chamberRepository.searchChamberWithPrice2(pageable,type, vip);
    }

    @Override
    public Page<Chamber> searchChamberWithPrice3(Pageable pageable,String type, String vip) {
        return chamberRepository.searchChamberWithPrice3(pageable,type, vip);
    }

    @Override
    public void updateCheckIn(Long id) {
        chamberRepository.updateChamberIsEmpty("false", id);
    }

    @Override
    public void updateCheckOut(Long id) {
        chamberRepository.updateChamberIsEmpty("true", id);
    }

    @Override
    public Page<Chamber> searchChamber(Pageable pageable, String text) {
        return chamberRepository.searchChamber(pageable,"%"+ text.trim() + "%");
    }

    @Override
    public void updateChamberInfo(String number, String type, String price, String area, String note, String vip,Long id) {
        chamberRepository.updateChamberInfo(number, type, price, area, note, vip, id);
    }

    @Override
    public void addChamber(String number, String type, String price, String area, String note, String fvip) {
        Chamber chamber = new Chamber(number, type, fvip, price, area, note, "true"); // mac dinh khi them la phong trong
        chamberRepository.save(chamber);
    }

    @Override
    public List<Chamber> findAllChamber() {
        List<Chamber> chambers = new ArrayList<>();
        chamberRepository.findAll().forEach(chambers::add);
        return chambers;
    }

    @Override
    public List<Chamber> searchRoom(String expectedArrivalDate,
                                    String expectDepartureDate,
                                    int numberAudults,
                                    int numberChild,
                                    int numberRoom,
                                    String roomCategory) {
        List<Chamber> chambers = new ArrayList<>();
        chamberRepository.searchChamberWithChamberType(roomCategory).forEach(chambers::add);
        return chambers;
    }
}
