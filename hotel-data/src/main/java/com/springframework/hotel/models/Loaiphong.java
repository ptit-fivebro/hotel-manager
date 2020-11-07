package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Loaiphong
{
    @Id
    @Column(name = "MALOAIPHONG")
    private String maloaiphong;

    @Column(name = "TENLOAIPHONG")
    private String tenloaiphong;

    @Column(name = "SOLUONG")
    private int soluong;

    @Column(name = "GIA")
    private double gia;

    @Column(name = "HINHANH")
    private String hinhanh;

    @Column(name = "MOTA")
    private String mota;

    @OneToMany(mappedBy = "loaiphong_phong",cascade = CascadeType.ALL)
    private List<Phong> phong;

    @OneToMany(mappedBy = "loaiphong_ctpd",cascade = CascadeType.ALL)
    private List<Chitietphieudat>chitietphieudatList;
}