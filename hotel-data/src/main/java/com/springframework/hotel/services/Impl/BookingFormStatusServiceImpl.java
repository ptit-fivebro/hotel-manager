package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.BookingFormStatus;
import com.springframework.hotel.repositories.BookingFormRepository;
import com.springframework.hotel.repositories.BookingFormStatusRepository;
import com.springframework.hotel.services.IBookingFormStatusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingFormStatusServiceImpl implements IBookingFormStatusService {
    private BookingFormStatusRepository bookingFormStatusRepository;

    public BookingFormStatusServiceImpl(BookingFormStatusRepository bookingFormStatusRepository) {
        this.bookingFormStatusRepository = bookingFormStatusRepository;
    }

    @Override
    public List<BookingFormStatus> findAll() {
        List<BookingFormStatus> bookingFormStatuses = new ArrayList<>();
        bookingFormStatusRepository.findAll().forEach(bookingFormStatuses::add);
        return bookingFormStatuses;
    }

    @Override
    public BookingFormStatus findById(Integer integer) {
        Optional<BookingFormStatus> bookingFormStatus = bookingFormStatusRepository.findById(integer);
        return bookingFormStatus.orElse(null);
    }

    @Override
    public BookingFormStatus save(BookingFormStatus object) {
        return bookingFormStatusRepository.save(object);
    }

    @Override
    public void delete(BookingFormStatus object) {
        bookingFormStatusRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        bookingFormStatusRepository.deleteById(integer);
    }
}
