package com.protas.weatherapp.weatherapp.entity;

import com.protas.weatherapp.weatherapp.model.TemperatureUnit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private double temperature;
    private TemperatureUnit temperatureUnit;
    private Integer atmosphericPressure;
}
