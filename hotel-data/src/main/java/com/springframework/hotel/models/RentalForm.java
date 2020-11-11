package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Rental_Form")
public class RentalForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RENTAL_FORM")
    private int idRentalForm;

    @Column(name = "ARRIVAL_DATE")
    private Date arrivalDate;

    @Column(name = "DEPARTURE_DATE")
    private Date departureDate;

    @OneToMany(mappedBy = "rentalForm", cascade = CascadeType.ALL)
    private List<RentalFormDetail> rentalFormDetailList;

    @OneToMany(mappedBy = "rentalForm", cascade = CascadeType.ALL)
    private List<Bill> billList;

    @ManyToOne
    @JoinColumn(name = "ID_BOOKING")
    private BookingForm bookingForm;
}