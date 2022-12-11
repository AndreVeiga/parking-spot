package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.common.dto.CarDto;
import com.api.parkingcontrol.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> getAll() {
        var response = this.service.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
