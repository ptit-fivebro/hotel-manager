package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.BookingFormDetail;
import com.springframework.hotel.repositories.BookingFormDetailRepository;
import com.springframework.hotel.services.IBookingFormDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingFormDetailServiceImpl implements IBookingFormDetailService {
    private BookingFormDetailRepository bookingFormDetailRepository;

    public BookingFormDetailServiceImpl(BookingFormDetailRepository bookingFormDetailRepository) {
        this.bookingFormDetailRepository = bookingFormDetailRepository;
    }

    @Override
    public List<BookingFormDetail> findAll() {
        List<BookingFormDetail> bookingFormDetails = new ArrayList<>();
        bookingFormDetailRepository.findAll().forEach(bookingFormDetails::add);
        return bookingFormDetails;
    }

    @Override
    public BookingFormDetail findById(Integer integer) {
        Optional<BookingFormDetail> bookingFormDetail = bookingFormDetailRepository.findById(integer);
        return bookingFormDetail.orElse(null);
    }

    @Override
    public BookingFormDetail save(BookingFormDetail object) {
        return bookingFormDetailRepository.save(object);
    }

    @Override
    public void delete(BookingFormDetail object) {
        bookingFormDetailRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        bookingFormDetailRepository.deleteById(integer);

    }
}
