package com.protas.weatherapp.weatherapp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.protas.weatherapp.weatherapp.converter.TemperatureUnitConverter;
import com.protas.weatherapp.weatherapp.model.TemperatureUnit;
import com.protas.weatherapp.weatherapp.serialize.TemperatureUnitDeserializer;
import jakarta.persistence.Convert;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDataRequest {
    private Double temperature;
    @Enumerated
    @JsonDeserialize(using = TemperatureUnitDeserializer.class)
    @Convert(converter = TemperatureUnitConverter.class)
    private TemperatureUnit temperatureUnit;
    private Integer atmosphericPressure;
}
