package com.protas.weatherapp.weatherapp.dto;

import com.protas.weatherapp.weatherapp.model.TemperatureUnit;
import jakarta.persistence.Enumerated;

public record WeatherDataDTO(Double temperature,
                             @Enumerated TemperatureUnit temperatureUnit,
                             Integer atmosphericPressure) {
}
