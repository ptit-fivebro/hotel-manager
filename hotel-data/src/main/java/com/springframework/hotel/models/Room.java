package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Room")
public class Room {
    @Id
    @Column(name = "ID_ROOM")
    private int idRoom;

    @Column(name = "FLOOR_NUMBER")
    private int floorNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROOM_CATEGORY")
    private RoomCategory roomCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROOM_STATUS")
    private RoomStatus roomStatus;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RentalFormDetail> rentalFormDetailList;
}