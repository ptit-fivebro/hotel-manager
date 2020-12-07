package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Room_Category")
public class RoomCategory {
    @Id
    @Column(name = "ID_ROOM_CATEGORY")
    private int idRoomCategory;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NUMBER")
    private int number;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "roomCategory", cascade = CascadeType.ALL)
    private List<Room> roomList;

    @OneToMany(mappedBy = "roomCategory", cascade = CascadeType.ALL)
    private List<BookingFormDetail> bookingFormDetailList;
}