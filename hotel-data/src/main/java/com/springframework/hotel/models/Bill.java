package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idBill;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "total_food")
    private double totalFood = 0;

    @Column(name = "total_service")
    private double totalService = 0;

    @Column(name = "total_rent")
    private double totalRent = 0;

    @Column(name = "total_pay")
    private double totalPay = 0;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
