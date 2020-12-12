package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idBooking;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "expected_arrival_date")
    private LocalDateTime expectedArrivalDate;

    @Column(name = "expected_departure_date")
    private LocalDateTime expectDepartureDate;

    @Column(name = "numberAudults")
    private int numberAudults = 0;

    @Column(name = "numberChild")
    private int numberChild = 0;

    @Column(name = "numberRoom")
    private int numberRoom = 0;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "chamber_id")
    private Chamber chamber;
}
