package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;

@Data
public class Chitietphieudat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MACHITIETPHIEUDAT")
    private int machitietphieudat;

    @Column(name = "SOLUONG")
    private int soluong;


    @ManyToOne
    @JoinColumn(name = "MAPHIEUDAT")
    private Phieudat phieudat_ctpd;

    @ManyToOne
    @JoinColumn(name = "MALOAIPHONG")
    private Loaiphong loaiphong_ctpd;
}