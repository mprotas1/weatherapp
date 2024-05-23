package com.protas.weatherapp.weatherapp.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.protas.weatherapp.weatherapp.dto.WeatherDataRequest;
import com.protas.weatherapp.weatherapp.model.TemperatureUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TemperatureUnitDeserializerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldDeserializeFullTemperatureUnit() {
        String jsonString = """
                {
                    "temperature":12.78,
                    "temperatureUnit": "CELSIUS",
                    "atmosphericPressure": "1020"
                }
                """;
        WeatherDataRequest request = objectMapper.convertValue(jsonString, WeatherDataRequest.class);
        assertNotNull(request.getTemperatureUnit());
        assertEquals(request.getTemperatureUnit(), TemperatureUnit.CELSIUS);
    }

    @Test
    void shouldDeserializeShortTemperatureUnit() {
        String jsonString = """
                {
                    "temperature":12.78,
                    "temperatureUnit": "C",
                    "atmosphericPressure": "1020"
                }
                """;
        WeatherDataRequest request = objectMapper.convertValue(jsonString, WeatherDataRequest.class);
        assertNotNull(request.getTemperatureUnit());
        assertEquals(request.getTemperatureUnit(), TemperatureUnit.CELSIUS);
    }
}
