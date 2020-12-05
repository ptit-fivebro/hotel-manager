package com.springframework.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {

    private String password;

    private String name;

    private String email;

    private String phone;
}
