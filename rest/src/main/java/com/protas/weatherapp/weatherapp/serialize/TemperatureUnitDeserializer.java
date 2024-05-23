package com.protas.weatherapp.weatherapp.serialize;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.protas.weatherapp.weatherapp.model.TemperatureUnit;

import java.io.IOException;

public class TemperatureUnitDeserializer extends JsonDeserializer<TemperatureUnit> {

    @Override
    public TemperatureUnit deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText();
        return TemperatureUnit.fromString(value);
    }

}

