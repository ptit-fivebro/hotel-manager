package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class Hoadon
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAHOADON")
    private int mahoadon;

    @Column(name = "NGAYXUATHOADON")
    private Date ngayxuathoadon;

    @Column(name = "TONGTIENTHUEPHONG")
    private double tongtienthuephong;

    @Column(name = "TIENDICHVU")
    private double tiendichvu;

    @Column(name = "SOTIENTAIKHOAN")
    private double sotientaikhoan;



    @ManyToOne
    @JoinColumn(name = "MAPHIEUTHUE")
    private Phieuthue phieuthue_hoadon;
}