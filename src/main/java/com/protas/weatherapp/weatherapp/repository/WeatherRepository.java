package com.protas.weatherapp.weatherapp.repository;

import com.protas.weatherapp.weatherapp.entity.WeatherData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherData, Long> {
}
