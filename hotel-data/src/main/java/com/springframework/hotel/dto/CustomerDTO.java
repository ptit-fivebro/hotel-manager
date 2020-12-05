package com.springframework.hotel.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CustomerDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;

    private String cmnd;

    private String password;

    private String name;

    private String email;

    private String phone;

    private boolean gender;

    private String address;

    private String nationality;

    private boolean active;

    private String image;
}
