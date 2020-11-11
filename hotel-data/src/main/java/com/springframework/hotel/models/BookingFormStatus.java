package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Booking_Form_Status")
public class BookingFormStatus {
    @Id
    @Column(name = "ID_BOOKING_FORM_STATUS")
    private int idBookingFormStatus;

    @Column(name = "NAME")
    private String nanme;

    @OneToMany(mappedBy = "bookingFormStatus", cascade = CascadeType.ALL)
    private List<BookingForm> bookingFormList;
}