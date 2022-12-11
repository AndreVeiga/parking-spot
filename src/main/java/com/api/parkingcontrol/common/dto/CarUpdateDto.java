package com.api.parkingcontrol.common.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CarUpdateDto {
    @Size(max=10)
    private String place;
    @Size(max=40)
    private String owner;
    @Size(max=20)
    private String color;
    @Size(max=20)
    private String model;
    @Size(max=20)
    private String brand;
}
