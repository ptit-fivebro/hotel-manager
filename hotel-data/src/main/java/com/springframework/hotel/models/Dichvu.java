package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Dichvu
{
    @Id
    @Column(name = "MADICHVU")
    private int madichvu;

    @Column(name = "TENDICHVU")
    private String tendichvu;

    @Column(name = "GIA")
    private double gia;

    @Column(name = "DONVITINH")
    private String donvitinh;

    @Column(name = "MOTA")
    private String mota;

    @Column(name = "HINHANH")
    private String hinhanh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MALOAIDICHVU")
    private Loaidichvu loaidichvu;

    @OneToMany(mappedBy = "dichvu",cascade = CascadeType.ALL)
    private List<Chitietdichvu>chitietdichvuList;
}