package com.protas.weatherapp.weatherapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class WeatherDataController {

    @PostMapping
    ResponseEntity<String> saveData() {
        return ResponseEntity.ok("Success!");
    }
}
