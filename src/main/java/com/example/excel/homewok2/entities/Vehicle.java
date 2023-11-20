package com.example.excel.homewok2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "public",name = "vehicles")
public class Vehicle {
    @Id
    private Integer id;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "length")
    private Double length;

    @Column(name = "width")
    private Double width;

    @Column(name = "height")
    private Double height;

    @Column(name = "capacity")
    private Double capacity;

    @Column(name = "status")
    private boolean status;
}