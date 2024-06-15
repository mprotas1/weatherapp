package com.protas.weatherapp.weatherapp.service;

import com.protas.weatherapp.weatherapp.converter.TemperatureConverter;
import com.protas.weatherapp.weatherapp.dto.WeatherDataRequest;
import com.protas.weatherapp.weatherapp.dto.WeatherDataResponse;
import com.protas.weatherapp.weatherapp.entity.WeatherData;
import com.protas.weatherapp.weatherapp.mapper.WeatherDataMapper;
import com.protas.weatherapp.weatherapp.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final Logger logger = LogManager.getLogger(this.getClass().getName());
    private final WeatherRepository repository;
    private final WeatherDataMapper mapper;

    public WeatherDataResponse saveData(WeatherDataRequest weatherDataRequest) {
        WeatherData data = mapper.fromRequest(weatherDataRequest);
        logger.info("WeatherDataRequest: {}", weatherDataRequest);
        WeatherData savedData = repository.save(data);
        logger.info("Created {}", savedData);
        return mapper.toResponse(savedData);
    }

    public List<WeatherDataResponse> findAll() {
        List<WeatherData> data = repository.findAll();
        return data.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Double getMean() {
        var data = findAll();
        return data.stream()
                .mapToDouble(temperatureData -> TemperatureConverter.toCelsius(temperatureData.getTemperature(),temperatureData.getUnit()))
                .average()
                .orElse(0.0);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
