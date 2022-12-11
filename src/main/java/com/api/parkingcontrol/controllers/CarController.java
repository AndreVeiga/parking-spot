package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.common.dto.CarDto;
import com.api.parkingcontrol.common.dto.CarUpdateDto;
import com.api.parkingcontrol.models.CarModel;
import com.api.parkingcontrol.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody @Valid CarDto data) {
        var response = this.service.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<List<CarModel>> getAll() {
        var response = this.service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{place}")
    public ResponseEntity<Object> getByPlace(@PathVariable(value = "place") String place) {
        Optional<CarModel> response = Optional.ofNullable(this.service.getByPlace(place));

        if(response.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{place}")
    public ResponseEntity<Object> deleteByPlace(@PathVariable(value = "place") String place) {
        Optional<CarModel> response = Optional.ofNullable(this.service.getByPlace(place));

        if(response.isPresent()) {
            this.service.deleteByPlace(place);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{place}")
    public ResponseEntity<Object> updateByPlace(
            @PathVariable(value = "place") String place,
            @RequestBody @Valid CarUpdateDto data) {
        this.service.update(place, data);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
