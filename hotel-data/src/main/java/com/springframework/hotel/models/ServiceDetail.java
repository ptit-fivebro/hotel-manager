package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Service_Detail")
public class ServiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICE_DETAIL", nullable = false)
    private int idServiceDetail;

    @Column(name = "DATE_USED")
    private Date dateUsed;

    @Column(name = "NUMBER")
    private int number;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "NOTE")
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RENTAL_FORM_DETAIL")
    private RentalFormDetail rentalFormDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SERVICE")
    private Service service;
}