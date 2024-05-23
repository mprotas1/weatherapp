package com.protas.weatherapp.weatherapp.mapper;

import com.protas.weatherapp.weatherapp.dto.WeatherDataRequest;
import com.protas.weatherapp.weatherapp.dto.WeatherDataResponse;
import com.protas.weatherapp.weatherapp.entity.WeatherData;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class WeatherDataMapper {
    private final ModelMapper modelMapper;
    private final TypeMap<WeatherDataRequest, WeatherData> requestToWeatherDataMap;
    private final Clock clock;

    public WeatherData fromRequest(WeatherDataRequest request) {
        WeatherData weatherData = requestToWeatherDataMap.map(request);
        weatherData.setDateTime(LocalDateTime.ofInstant(clock.instant(), ZoneId.systemDefault()));
        return weatherData;
    }

    public WeatherDataResponse toResponse(WeatherData weatherData) {
        return modelMapper.map(weatherData, WeatherDataResponse.class);
    }
}
