package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Chamber;
import com.springframework.hotel.repositories.ChamberRepository;
import com.springframework.hotel.services.IChamberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChamberServiceImpl implements IChamberService {

    @Autowired
    private ChamberRepository chamberRepository;

    @Override
    public Chamber findChamber(Long id) {
        // TODO Auto-generated method stub
        return chamberRepository.getOne(id);
    }

    @Override
    public void deleteChamber(Long chamberId) {
        // TODO Auto-generated method stub
        chamberRepository.deleteById(chamberId);
    }

    @Override
    public Page<Chamber> searchChamberWithPrice1(Pageable pageable,String type, String vip) {
        return chamberRepository.searchChamberWithPrice1(pageable,type, vip);
    }

    @Override
    public Page<Chamber> searchChamberWithPrice2(Pageable pageable,String type, String vip) {
        // TODO Auto-generated method stub
        return chamberRepository.searchChamberWithPrice2(pageable,type, vip);
    }

    @Override
    public Page<Chamber> searchChamberWithPrice3(Pageable pageable,String type, String vip) {
        // TODO Auto-generated method stub
        return chamberRepository.searchChamberWithPrice3(pageable,type, vip);
    }

    @Override
    public void updateCheckIn(Long id) {
        chamberRepository.updateChamberIsEmpty("false", id);
    }

    @Override
    public Page<Chamber> searchChamber(Pageable pageable, String text) {
        // TODO Auto-generated method stub
        return chamberRepository.searchChamber(pageable,"%"+ text.trim() + "%");
    }

    @Override
    public void updateChamberInfo(String number, String type, String price, String area, String note, String vip,Long id) {
        // TODO Auto-generated method stub
        chamberRepository.updateChamberInfo(number, type, price, area, note, vip, id);
    }

    @Override
    public void addChamber(String number, String type, String price, String area, String note, String fvip) {
        // TODO Auto-generated method stub
        Chamber chamber = new Chamber(number, type, fvip, price, area, note, "true"); // mac dinh khi them la phong trong
        chamberRepository.save(chamber);
    }
}