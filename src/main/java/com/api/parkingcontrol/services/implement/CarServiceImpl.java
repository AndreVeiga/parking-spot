package com.api.parkingcontrol.services.implement;

import com.api.parkingcontrol.common.dto.CarDto;
import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.repositories.CarRepository;
import com.api.parkingcontrol.services.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Override
    public CarModel create(CarDto data) {
        CarModel car = new CarModel();
        BeanUtils.copyProperties(data, car);
        return this.repository.save(car);
    }

    @Override
    public List<CarModel> getAll() {
        return this.repository.findAll();
    }

    @Override
    public CarModel getByPlace(String place) {
        return this.repository.findByPlace(place);
    }

    @Override
    public void update(CarDto car) {}

    @Override
    public void deleteByPlace(String place) {}
}
