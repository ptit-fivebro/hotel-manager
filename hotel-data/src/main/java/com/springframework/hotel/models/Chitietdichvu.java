package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class Chitietdichvu
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MACHITIETDICHVU",nullable = false)
    private int machitietdichvu;

    @Column(name = "NGAYSUDUNG")
    private Date ngaysudung;

    @Column(name = "SOLUONG")
    private int soluong;

    @Column(name = "TIEN")
    private double tien;

    @Column(name = "GHICHU")
    private String ghichu;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MACHITIETPHIEUTHUE")
    private int machitietphieuthue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MADICHVU")
    private Dichvu dichvu;
}