package com.protas.weatherapp.weatherapp.model;

import lombok.Getter;

import java.util.Arrays;
import java.util.IllformedLocaleException;

@Getter
public enum TemperatureUnit {
    CELSIUS("C"),
    FAHRENHEIT("F");

    private final String abbreviation;

    TemperatureUnit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static TemperatureUnit fromString(String temperatureUnitLiteral) {
        return Arrays.stream(TemperatureUnit.values())
                .filter(unit -> isValueValidTemperatureUnit(unit, temperatureUnitLiteral))
                .findFirst()
                .orElseThrow(() -> new IllformedLocaleException(temperatureUnitLiteral + " is not a valid temperature unit"));
    }

    private static boolean isValueValidTemperatureUnit(TemperatureUnit temperatureUnit, String temperatureUnitLiteral) {
        return temperatureUnit.getAbbreviation().equals(temperatureUnitLiteral) || temperatureUnit.name().equals(temperatureUnitLiteral);
    }
}
