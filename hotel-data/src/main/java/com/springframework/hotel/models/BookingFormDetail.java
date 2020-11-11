package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Booking_Form_Detail")
public class BookingFormDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BOOKING_DETAIL")
    private int idBookingDetail;

    @Column(name = "NUMBER")
    private int number;

    @ManyToOne
    @JoinColumn(name = "ID_BOOKING")
    private BookingForm bookingForm;

    @ManyToOne
    @JoinColumn(name = "ID_ROOM_CATEGORY")
    private RoomCategory roomCategory;
}