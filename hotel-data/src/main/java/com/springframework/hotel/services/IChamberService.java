package com.springframework.hotel.services;

import com.springframework.hotel.models.Chamber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IChamberService {

    Chamber findChamber(Long id);

    Page<Chamber> searchChamber(Pageable pageable,String text);

    Page<Chamber> searchChamberWithPrice1(Pageable pageable,String type,String vip);

    Page<Chamber> searchChamberWithPrice2(Pageable pageable,String type,String vip);

    Page<Chamber> searchChamberWithPrice3(Pageable pageable,String type,String vip);

    void addChamber(String number, String type, String price, String area, String note, String fvip);

    void deleteChamber(Long chamberId);

    void updateCheckIn(Long id); // update lai trang thai phong khi check in

    void updateCheckOut(Long id); // update lai trang thai phong khi check out

    void updateChamberInfo(String number, String type, String price, String area, String note, String vip,Long id);

    List<Chamber> findAllChamber();

    List<Chamber> searchRoom(String expectedArrivalDate,
                             String expectDepartureDate,
                             int numberAudults,
                             int numberChild,
                             int numberRoom,
                             String roomCategory);
}
