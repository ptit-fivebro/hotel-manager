package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Room_Status")
public class RoomStatus {
    @Id
    @Column(name = "ID_ROOM_STATUS")
    private int idRoomStatus;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "roomStatus", cascade = CascadeType.ALL)
    private List<Room> roomList;
}