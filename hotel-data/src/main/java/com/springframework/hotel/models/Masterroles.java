package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;

@Data
public class Masterroles
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MasterRoleId")
    private int masterroleid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANHANVIEN")
    private Nhanvien nhanvien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MABOPHAN")
    private Bophan bophan;
}