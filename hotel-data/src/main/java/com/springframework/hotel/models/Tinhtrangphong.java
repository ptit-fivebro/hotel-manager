package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Tinhtrangphong
{
    @Id
    @Column(name = "MATINHTRANGPHONG")
    private int matinhtrangphong;

    @Column(name = "TENTINHTRANGPHONG")
    private String tentinhtrangphong;

    @OneToMany(mappedBy = "tinhtrangphong",cascade = CascadeType.ALL)
    private List<Phong> phongList;
}