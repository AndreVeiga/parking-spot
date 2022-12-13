package com.api.parkingcontrol.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "spot")
public class SpotModel implements Serializable {
    private static final long serialVersionIdUID = 1L;

    @Id
    @Column(nullable = false, unique = true, length = 4)
    private String number;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private LocalDateTime updateAt;

    @OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private CarModel car;

}
