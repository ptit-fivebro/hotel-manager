package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Chitietphieuthue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MACHITIETPHIEUTHUE")
    private int machitietphieuthue;

    @Column(name = "KHACHHANG1")
    private String khachhang1;

    @Column(name = "CMNDKHACH1")
    private String cmndkhach1;

    @Column(name = "KHACHHANG2")
    private String khachhang2;

    @Column(name = "CMNDKHACH2")
    private String cmndkhach2;

    @Column(name = "TONGTIENDICHVUPHONG")
    private double tongtiendichvuphong;

    @Column(name = "TONGTIENTHUEPHONG")
    private double tongtienthuephong;

    @OneToMany(mappedBy = "dichvu",cascade = CascadeType.ALL)
    private List<Chitietdichvu>chitietdichvu;

    @ManyToOne
    @JoinColumn(name = "MAPHIEUTHUE")
    private Phieuthue phieuthue_ctpt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAPHONG")
    private Phong phong;
}