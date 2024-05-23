package com.protas.weatherapp.weatherapp.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.protas.weatherapp.weatherapp.model.TemperatureUnit;
import com.protas.weatherapp.weatherapp.serialize.TemperatureUnitSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WeatherDataResponse {
    private Long id;
    private Double temperature;
    @JsonSerialize(using = TemperatureUnitSerializer.class)
    private TemperatureUnit unit;
    private Double atmosphericPressure;
    private LocalDateTime creationDateTime;
}