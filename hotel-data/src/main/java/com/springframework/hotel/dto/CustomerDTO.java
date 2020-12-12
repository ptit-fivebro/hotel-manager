package com.springframework.hotel.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private int id;

    private String cmnd;

    private String password;

    private String name;

    private String email;

    private String phone;

    private boolean gender;

    private String address;

    private String nationality;

    private boolean active = true;

    private String image;
}
