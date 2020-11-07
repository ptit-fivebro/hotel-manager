package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class Gopy
{
    @Id
    @Column(name = "MAKHACHHANG")
    private int makhachhang;

    @Column(name = "NGAYGUI")
    private Date ngaygui;

    @Column(name = "NOIDUNG")
    private String noidung;

    @Column(name = "TRALOI")
    private String traloi;
}