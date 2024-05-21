package com.protas.weatherapp.weatherapp.dto;

import com.protas.weatherapp.weatherapp.model.TemperatureUnit;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WeatherDataResponse {
    private Double temperature;
    private TemperatureUnit unit;
    private Double atmosphericPressure;
    private LocalDateTime creationDateTime;
}