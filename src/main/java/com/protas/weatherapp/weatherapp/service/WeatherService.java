package com.protas.weatherapp.weatherapp.service;

import com.protas.weatherapp.weatherapp.dto.WeatherDataDTO;
import com.protas.weatherapp.weatherapp.entity.WeatherData;
import com.protas.weatherapp.weatherapp.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository repository;
    private final Clock clock;

    public WeatherDataDTO saveData(WeatherDataDTO weatherDataDTO) {
        var data = fromDTO(weatherDataDTO);
        repository.save(data);
        return weatherDataDTO;
    }

    private WeatherData fromDTO(WeatherDataDTO weatherDataDTO) {
        WeatherData data = new WeatherData();
        data.setTemperature(weatherDataDTO.temperature());
        data.setTemperatureUnit(weatherDataDTO.temperatureUnit());
        data.setDateTime(LocalDateTime.now(clock));
        data.setAtmosphericPressure(weatherDataDTO.atmosphericPressure());

        return data;
    }

    public List<WeatherDataDTO> findAll() {
        List<WeatherDataDTO> dtos = new ArrayList<>();
        var weatherData = repository.findAll();

        for(WeatherData data : weatherData) {
            WeatherDataDTO dto = new WeatherDataDTO(data.getTemperature(),data.getTemperatureUnit(),data.getAtmosphericPressure());
            dtos.add(dto);
        }
        return dtos;
    }
}
