package com.springframework.hotel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Service_Category")
public class ServiceCategory {
    @Id
    @Column(name = "ID_SERVICE_CATEGORY")
    private int idServiceCategory;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "serviceCategory", cascade = CascadeType.ALL)
    private List<Service> serviceList;

}