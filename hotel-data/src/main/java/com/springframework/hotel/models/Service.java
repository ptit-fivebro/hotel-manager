package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Service")
public class Service {
    @Id
    @Column(name = "ID_SERVICE")
    private int idService;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE_SERVICE")
    private double priceService;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SERVICE_CATEGORY")
    private ServiceCategory serviceCategory;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<ServiceDetail> serviceDetailList;
}