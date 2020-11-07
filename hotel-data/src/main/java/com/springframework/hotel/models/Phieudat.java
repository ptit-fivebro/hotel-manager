package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class Phieudat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPHIEUDAT")
    private int maphieudat;

    @Column(name = "NGAYDAT")
    private Date ngaydat;

    @Column(name = "NGAYDENDUKIEN")
    private Date ngaydendukien;

    @Column(name = "NGAYDIDUKIEN")
    private Date ngaydidukien;

    @OneToMany(mappedBy = "phieudat_ctpd",cascade = CascadeType.ALL)
    private Chitietphieudat chitietphieudatList;

    @OneToMany(mappedBy = "phieudat_phieuthue",cascade = CascadeType.ALL)
    private List<Phieuthue> phieuthueList;

    @ManyToOne
    @JoinColumn(name = "MATINHTRANG")
    private Tinhtrangphieudat tinhtrangphieudat;

    @ManyToOne
    @JoinColumn(name = "MAKHACHHANG")
    private Khachhang khachhang;
}