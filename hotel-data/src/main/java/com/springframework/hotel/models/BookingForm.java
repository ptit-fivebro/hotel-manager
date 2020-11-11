package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Booking_Form")
public class BookingForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BOOKING")
    private int idBooking;

    @Column(name = "BOOKING_DATE")
    private LocalDateTime bookingDate;

    @Column(name = "EXPECTED_ARRIVAL_DATE")
    private LocalDateTime expectedArrivalDate;

    @Column(name = "EXPECTED_DEPARTURE_DATE")
    private LocalDateTime expectDepartureDate;

    @OneToMany(mappedBy = "bookingForm", cascade = CascadeType.ALL)
    private List<BookingFormDetail> bookingFormDetailList;

    @OneToMany(mappedBy = "bookingForm", cascade = CascadeType.ALL)
    private List<RentalForm> rentalFormList;

    @ManyToOne
    @JoinColumn(name = "ID_BOOKING_FORM_STATUS")
    private BookingFormStatus bookingFormStatus;

    @ManyToOne
    @JoinColumn(name = "ID_CUSTOMER")
    private Customer customer;
}