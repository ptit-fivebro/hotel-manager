package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Nhanvien
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANHANVIEN")
    private int manhanvien;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "TENNHANVIEN")
    private String tennhanvien;

    @Column(name = "CMND")
    private String cmnd;

    @Column(name = "GIOITINH")
    private String gioitinh;

    @Column(name = "SODIENTHOAI")
    private String sodienthoai;

    @Column(name = "DIACHI")
    private String diachi;

    @Column(name = "LUONG")
    private double luong;
}