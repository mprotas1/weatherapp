package com.protas.weatherapp.weatherapp.repository;

import com.protas.weatherapp.weatherapp.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
}
