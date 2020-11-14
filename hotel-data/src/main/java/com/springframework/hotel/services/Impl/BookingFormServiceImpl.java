package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.BookingForm;
import com.springframework.hotel.repositories.BookingFormRepository;
import com.springframework.hotel.services.IBookingFormService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingFormServiceImpl implements IBookingFormService {
    private BookingFormRepository bookingFormRepository;

    public BookingFormServiceImpl(BookingFormRepository bookingFormRepository) {
        this.bookingFormRepository = bookingFormRepository;
    }

    @Override
    public List<BookingForm> findAll() {
        List<BookingForm> bookingForms=new ArrayList<>();
        bookingFormRepository.findAll().forEach(bookingForms::add);
        return bookingForms;
    }

    @Override
    public BookingForm findById(Integer integer) {
        Optional<BookingForm>bookingForm=bookingFormRepository.findById(integer);
        return bookingForm.orElse(null);
    }

    @Override
    public BookingForm save(BookingForm object) {
        return bookingFormRepository.save(object);
    }

    @Override
    public void delete(BookingForm object) {
        bookingFormRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        bookingFormRepository.deleteById(integer);
    }
}
