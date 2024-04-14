package com.protas.weatherapp.weatherapp.config;

import jakarta.validation.ClockProvider;
import org.hibernate.type.descriptor.java.ClockHelper;
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

}
