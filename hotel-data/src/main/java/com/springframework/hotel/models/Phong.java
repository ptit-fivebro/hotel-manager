package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Phong
{
    @Id
    @Column(name = "MAPHONG")
    private int maphong;

    @Column(name = "TANG")
    private int tang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MALOAIPHONG")
    private Loaiphong loaiphong_phong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATINHTRANGPHONG")
    private Tinhtrangphong tinhtrangphong;

    @OneToMany(mappedBy = "phong",cascade = CascadeType.ALL)
    private List<Chitietphieuthue>chitietphieuthueList;
}