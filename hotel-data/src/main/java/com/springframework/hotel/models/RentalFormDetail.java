package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Rental_Form_Detail")
public class RentalFormDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RENTAL_FORM_DETAIL")
    private int idRentalFormDetail;

    @Column(name = "CUSTOMER1")
    private String customer1;

    @Column(name = "CMND1")
    private String cmnd1;

    @Column(name = "CUSTOMER2")
    private String customer2;

    @Column(name = "CMND2")
    private String cmnd2;

    @Column(name = "TOTAL_SERVICE_PRICE")
    private double totalServicePrice;

    @Column(name = "TOTAL_RENTAL_PRICE")
    private double totalRentalPrice;

    @OneToMany(mappedBy = "rentalFormDetail", cascade = CascadeType.ALL)
    private List<ServiceDetail> serviceDetail;

    @ManyToOne
    @JoinColumn(name = "ID_RENTAL_FORM")
    private RentalForm rentalForm;

    @ManyToOne
    @JoinColumn(name = "ID_ROOM")
    private Room room;
}