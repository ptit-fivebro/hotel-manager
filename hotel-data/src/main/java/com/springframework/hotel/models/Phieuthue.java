package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class Phieuthue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPHIEUTHUE")
    private int maphieuthue;

    @Column(name = "NGAYDEN")
    private Date ngayden;

    @Column(name = "NGAYDI")
    private Date ngaydi;

    @OneToMany(mappedBy = "phieuthue_ctpt",cascade = CascadeType.ALL)
    private List<Chitietphieuthue> chitietphieuthueList;

    @OneToMany(mappedBy = "phieuthue_hoadon",cascade = CascadeType.ALL)
    private List<Hoadon> hoadonList;

    @ManyToOne
    @JoinColumn(name = "MAPHIEUDAT")
    private Phieudat phieudat_phieuthue;
}