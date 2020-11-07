package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Khachhang
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAKHACHHANG")
    private int makhachhang;

    @Column(name = "CMND_PASSPORT")
    private String cmnd_passport;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TENKHACHHANG")
    private String tenkhachhang;

    @Column(name = "EmailKhachHang")
    private String emailkhachhang;

    @Column(name = "SODIENTHOAI")
    private String sodienthoai;

    @Column(name = "GIOITINH")
    private boolean gioitinh;

    @Column(name = "QUEQUAN")
    private String quequan;

    @Column(name = "QUOCTINH")
    private String quoctich;

    @Column(name = "TINHTRANGTAIKHOAN")
    private String tinhtrangtaikhoan;

    @Column(name = "HINHANH")
    private String hinhanh;

    @Column(name = "DANHGIAKHACHSAN")
    private int danhgiakhachsan;

    @OneToMany(mappedBy = "khachhang",cascade = CascadeType.ALL)
    private List<Khachhang> khachhangList;


}