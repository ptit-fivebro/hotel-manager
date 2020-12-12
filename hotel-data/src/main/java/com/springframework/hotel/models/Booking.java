package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idBooking;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "expected_arrival_date")
    private Date expectedArrivalDate;

    @Column(name = "expected_departure_date")
    private Date expectDepartureDate;

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
