package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Part")
public class Part {
    @Id
    @Column(name = "ID_PART")
    private String idPart;

    @Column(name = "PART_NAME")
    private String partName;

    @ManyToMany
    private List<Employee> employeeList;
}