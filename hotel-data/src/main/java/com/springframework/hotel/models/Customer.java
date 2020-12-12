package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cmnd")
    private String cmnd;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "address")
    private String address;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "chamber", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Booking> bookingList;
}
