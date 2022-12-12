package com.api.parkingcontrol.services.implement;

import com.api.parkingcontrol.common.dto.CarDto;
import com.api.parkingcontrol.common.dto.CarUpdateDto;
import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.repositories.CarRepository;
import com.api.parkingcontrol.services.CarService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Override
    public CarModel create(CarDto data) {
        CarModel car = new CarModel();
        BeanUtils.copyProperties(data, car);
        car.setCreateAt(LocalDateTime.now(ZoneId.of("UTC")));
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
    public void update(String place, CarUpdateDto data) {
        Optional<CarModel> model = Optional.ofNullable(this.repository.findByPlace(place));

        if (model.isPresent()) {
            var car = model.get();
            Field[] dataFields = data.getClass().getDeclaredFields();
            Field[] carFields = car.getClass().getDeclaredFields();
            Map<String, String> prop_value = new HashMap<>();

            try {
                for(Field field : dataFields) {
                    field.setAccessible(true);
                    var target = (String) field.getName();
                    var result = (String) field.get(data);

                    if (!this.isNullOrEmpty(result)) {
                        prop_value.put(target, result);
                    }
                }

                for(Field field : carFields) {
                    field.setAccessible(true);
                    var name = field.getName();
                    if (prop_value.containsKey(name)) {
                        field.set(car, prop_value.get(name));
                    }
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }


            car.setPlace(model.get().getPlace());
            this.repository.save(car);
        }
    }

    @Override
    @Transactional
    public void deleteByPlace(String place) {
        this.repository.deleteById(place);
    }

    private Boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
