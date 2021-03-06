package com.springframework.hotel.services.Impl;

import java.util.List;

import com.springframework.hotel.models.Guest;
import com.springframework.hotel.repositories.GuestRepository;
import com.springframework.hotel.services.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements IGuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Guest findGuest(Long id) {
        return guestRepository.findById(id).get();
    }

    @Override
    public void addGuestInfo(Guest guest) {
        guestRepository.save(guest);
    }

    @Override
    public void editGuestInfo(Guest guest) {
        guestRepository.save(guest);
    }

    @Override
    public Page<Guest> searchGuests(Pageable pageable, String text) {
        return guestRepository.searchGuests(pageable,"%"+text.trim()+"%");
        // "%"+text.trim()+"%" xu ly tu khoa(vd: ___Huong..! -> %Huong..!%)
    }

    @Override
    public List<Guest> searchGuests(String text) {
        return guestRepository.searchGuests("%"+text.trim()+"%");
    }

    @Override
    public Guest searchGuestWithCart(String idCard) {
        return guestRepository.searchGuestWithCart(idCard);
    }

    @Override
    public Integer checkExistGuest(String idCard) {
        return guestRepository.checkExistGuest(idCard);
    }

    @Override
    public void updateComplete(String passport, String address, String phoneNumber, String email, String isVip,
                               String idCard) {

        guestRepository.updateComplete(passport, address, phoneNumber, email, "true", isVip, idCard);
        // mac dinh nhu update check in ma khach da co trong csdl thi familiar = true
    }

    @Override
    public void updateNomal(String guestName, String birth, String idCard, String passport, String address,
                            String nationality, String phoneNumber, String email, Long guestId) {

        guestRepository.updateNomal(guestName, birth, idCard, passport, address, nationality, phoneNumber, email, guestId);
    }

    @Override
    public Guest getGuestInfoByChamberNumber(String chamberNumber) {
        return guestRepository.getGuestInfoByChamberNumber(chamberNumber);
    }
}
