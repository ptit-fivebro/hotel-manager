package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Tinhtrangphieudat
{
    @Id
    @Column(name = "MATINHTRANG")
    private int matinhtrang;

    @Column(name = "TENTINHTRANG")
    private String tentinhtrang;

    @OneToMany(mappedBy = "tinhtrangphieudat",cascade = CascadeType.ALL)
    private List<Phieudat> phieudatList;
}