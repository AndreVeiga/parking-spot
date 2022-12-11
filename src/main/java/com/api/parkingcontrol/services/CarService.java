package com.api.parkingcontrol.services;

import com.api.parkingcontrol.common.dto.CarDto;
import com.api.parkingcontrol.common.dto.CarUpdateDto;
import com.api.parkingcontrol.models.CarModel;

import java.util.List;

public interface CarService {
    CarModel create(CarDto car);

    List<CarModel> getAll();

    CarModel getByPlace(String place);

    void update(String place, CarUpdateDto data);

    void deleteByPlace(String place);
}
