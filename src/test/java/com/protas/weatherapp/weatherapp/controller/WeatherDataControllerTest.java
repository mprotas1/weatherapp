package com.protas.weatherapp.weatherapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.protas.weatherapp.weatherapp.dto.WeatherDataDTO;
import com.protas.weatherapp.weatherapp.model.TemperatureUnit;
import jakarta.annotation.sql.DataSourceDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WeatherDataControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldAddWeatherData() throws Exception {
        WeatherDataDTO dto = new WeatherDataDTO(25.4, TemperatureUnit.CELSIUS, 1025);
        String body = objectMapper.writeValueAsString(dto);

        var result = mockMvc.perform(post("/data")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("temperature").value("25.4"))
                .andExpect(jsonPath("atmosphericPressure").value("1025"))
                .andReturn();
    }
}
