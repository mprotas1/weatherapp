package com.protas.weatherapp.weatherapp.controller;

import com.protas.weatherapp.weatherapp.dto.WeatherDataDTO;
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
    ResponseEntity<WeatherDataDTO> saveData(@RequestBody @Valid WeatherDataDTO weatherDataDTO) {
        var data = weatherService.saveData(weatherDataDTO);
        return ResponseEntity.ok(data);
    }

    @GetMapping
    List<WeatherDataDTO> getAllData() {
        return weatherService.findAll();
    }
}
