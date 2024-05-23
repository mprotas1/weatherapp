package com.protas.weatherapp.weatherapp.config;

import com.protas.weatherapp.weatherapp.dto.WeatherDataRequest;
import com.protas.weatherapp.weatherapp.dto.WeatherDataResponse;
import com.protas.weatherapp.weatherapp.entity.WeatherData;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Clock;

@Configuration
public class ApplicationConfig {

    @Bean
    @Primary
    public Clock getClock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TypeMap<WeatherDataRequest, WeatherData> weatherDataTypeMap() {
        return modelMapper().createTypeMap(WeatherDataRequest.class, WeatherData.class)
                .addMappings(mapper -> mapper.map(WeatherDataRequest::getTemperatureUnit, WeatherData::setTemperatureUnit));
    }

    @Bean
    public TypeMap<WeatherData, WeatherDataResponse> weatherDataResponseMap() {
        return modelMapper().createTypeMap(WeatherData.class, WeatherDataResponse.class)
                .addMappings(mapper -> mapper.map(WeatherData::getDateTime, WeatherDataResponse::setCreationDateTime));
    }

}
