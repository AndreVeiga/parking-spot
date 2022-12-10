package com.api.parkingcontrol.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

import java.io.Serializable;

@Data
@Entity
@Table(name = "car")
public class CarModel implements Serializable {
    private static final long serialVersionIdUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 40)
    private String owner;

    @Column(nullable = false, length = 10)
    private String place;

    @Column(nullable = false, length = 20)
    private String color;

    @Column(nullable = false, length = 20)
    private String model;

    @Column(nullable = false, length = 20)
    private String brandCar;
}
