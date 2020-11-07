package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Loaidichvu
{
    @Id
    @Column(name = "MALOAIDICHVU")
    private int maloaidichvu;

    @Column(name="TENLOAIDICHVU")
    private String tenloaidichvu;

    @OneToMany(mappedBy = "loaidichvu",cascade = CascadeType.ALL)
    private List<Dichvu> dichvuList;

}