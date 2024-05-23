package com.protas.weatherapp.weatherapp.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.protas.weatherapp.weatherapp.model.TemperatureUnit;

import java.io.IOException;

public class TemperatureUnitSerializer extends JsonSerializer<TemperatureUnit> {
    @Override
    public void serialize(TemperatureUnit temperatureUnit, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(temperatureUnit.getAbbreviation());
    }
}
