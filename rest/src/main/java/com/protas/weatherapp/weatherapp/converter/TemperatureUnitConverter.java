package com.protas.weatherapp.weatherapp.converter;

import com.protas.weatherapp.weatherapp.model.TemperatureUnit;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TemperatureUnitConverter implements AttributeConverter<TemperatureUnit, String> {

    @Override
    public String convertToDatabaseColumn(TemperatureUnit temperatureUnit) {
        return temperatureUnit != null ? temperatureUnit.getAbbreviation() : TemperatureUnit.CELSIUS.getAbbreviation();
    }

    @Override
    public TemperatureUnit convertToEntityAttribute(String unitLiteral) {
        return TemperatureUnit.fromString(unitLiteral);
    }
}
