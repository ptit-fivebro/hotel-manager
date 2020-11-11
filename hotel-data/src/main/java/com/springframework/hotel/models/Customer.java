package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CUSTOMER")
    private int idCustomer;

    @Column(name = "CMND")
    private String cmnd;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "GENDER")
    private boolean gender;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "NATIONALITY")
    private String nationality;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "IMAGE")
    private String image;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contact> contactList;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<BookingForm> bookingFormList;
}