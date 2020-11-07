package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;

@Data
public class Bophan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MABOPHAN")
    private String mabophan;

    @Column(name = "TENBOPHAN")
    private String tenbophan;


}