package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.common.dto.SpotDto;
import com.api.parkingcontrol.services.implement.SpotServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/spots")
public class SpotController {
    @Autowired
    private SpotServiceImpl spotService;

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody @Valid SpotDto data) {
        var response = this.spotService.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
