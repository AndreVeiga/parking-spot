package com.api.parkingcontrol.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SpotDto {
    @NotBlank
    @Size(max=10)
    private String place;

    @NotBlank
    @Size(max=4)
    private String number;
}
