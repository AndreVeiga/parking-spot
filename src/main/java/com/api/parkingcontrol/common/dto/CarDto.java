package com.api.parkingcontrol.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CarDto {
    @NotBlank
    @Size(max=10)
    private String place;
    @NotBlank
    @Size(max=40)
    private String owner;
    @NotBlank
    @Size(max=20)
    private String color;
    @NotBlank
    @Size(max=20)
    private String model;
    @NotBlank
    @Size(max=20)
    private String brand;
}
