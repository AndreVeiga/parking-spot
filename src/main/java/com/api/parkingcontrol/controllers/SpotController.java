package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.services.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/spots")
public class SpotController {
    @Autowired
    private SpotService spotService;

    @GetMapping()
    public String get() {
        return "Teste";
    }
}
