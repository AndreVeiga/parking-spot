package com.api.parkingcontrol.services.implement;

import com.api.parkingcontrol.common.dto.SpotDto;
import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.models.SpotModel;
import com.api.parkingcontrol.repositories.SpotRepository;
import com.api.parkingcontrol.services.CarService;
import com.api.parkingcontrol.services.SpotService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Optional;

@Service
public class SpotServiceImpl implements SpotService {
    @Autowired
    private SpotRepository repository;

    @Autowired
    private CarService carService;

    @Override
    @Transactional
    public SpotModel create(SpotDto data) {
        Optional<CarModel> car = Optional.ofNullable(carService.getByPlace(data.getPlace()));

        if (!car.isPresent()) {
            throw new Error("Data invalid.");
        }

        var spot = new SpotModel();
        BeanUtils.copyProperties(data, spot);
        spot.setCar(car.get());
        spot.setCreateAt(LocalDateTime.now(ZoneId.of("UTC")));
        spot.setUpdateAt(LocalDateTime.now(ZoneId.of("UTC")));

        return this.repository.save(spot);
    }
}
