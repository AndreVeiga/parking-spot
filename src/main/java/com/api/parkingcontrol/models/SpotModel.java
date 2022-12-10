package com.api.parkingcontrol.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "spot")
public class SpotModel implements Serializable {
    private static final long serialVersionIdUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 4)
    private String number;

    @Column(nullable = false)
    private LocalDateTime createAt;

    private CarModel car;

}
