package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BILL")
    private int idBill;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "TOTAL_RENTAL_FORM")
    private double totalRetalForm;

    @Column(name = "TOTAL_SERVICE")
    private double totalService;

    @Column(name = "RECEIVED_AMOUNT")
    private double receivedAmount;

    @Column(name = "PAYMENT_AMOUNT")
    private double paymentAmount;

    @ManyToOne
    @JoinColumn(name = "ID_RENTAL_FORM")
    private RentalForm rentalForm;
}