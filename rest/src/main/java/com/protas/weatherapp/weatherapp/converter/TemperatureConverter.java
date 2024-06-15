package com.protas.weatherapp.weatherapp.converter;

import com.protas.weatherapp.weatherapp.model.TemperatureUnit;

public class TemperatureConverter {
    private static final double FAHRENHEIT_TO_CELSIUS_SCALE = 5.0 / 9.0;
    private static final double CELSIUS_TO_FAHRENHEIT_SCALE = 9.0 / 5.0;
    private static final double FAHRENHEIT_TO_CELSIUS_OFFSET = 32.0;

    public static Double fahrenheitToCelsius(Double temperature) {
        return (temperature - FAHRENHEIT_TO_CELSIUS_OFFSET) * FAHRENHEIT_TO_CELSIUS_SCALE;
    }

    public static Double celsiusToFahrenheit(Double temperature) {
        return (temperature * CELSIUS_TO_FAHRENHEIT_SCALE) + FAHRENHEIT_TO_CELSIUS_OFFSET;
    }

    public static double toCelsius(double temperature, TemperatureUnit unit) {
        if (unit.equals(TemperatureUnit.FAHRENHEIT)) {
            return fahrenheitToCelsius(temperature);
        }
        return temperature;
    }
}
