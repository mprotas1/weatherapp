package com.protas.weatherapp.weatherapp.controller;

import com.protas.weatherapp.weatherapp.dto.WeatherDataRequest;
import com.protas.weatherapp.weatherapp.dto.WeatherDataResponse;
import com.protas.weatherapp.weatherapp.service.WeatherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class WeatherDataController {
    private final WeatherService weatherService;

    @PostMapping
    ResponseEntity<WeatherDataResponse> saveData(@RequestBody @Valid WeatherDataRequest weatherDataRequest) {
        var data = weatherService.saveData(weatherDataRequest);
        return ResponseEntity.ok(data);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    List<WeatherDataResponse> getAllData() {
        return weatherService.findAll();
    }
}
