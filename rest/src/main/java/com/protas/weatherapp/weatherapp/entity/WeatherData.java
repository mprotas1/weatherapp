package com.protas.weatherapp.weatherapp.entity;

import com.protas.weatherapp.weatherapp.model.TemperatureUnit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor
public class WeatherData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperature;

    @Enumerated(EnumType.STRING)
    private TemperatureUnit temperatureUnit;

    private int atmosphericPressure;

    private LocalDateTime dateTime;
}
