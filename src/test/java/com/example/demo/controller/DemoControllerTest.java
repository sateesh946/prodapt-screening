package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Skeleton template for a controller test using MockMvc.
 *
 * You can use annotations from JUnit 5 such as @ParameterizedTest, @ValueSauce,
 * @CsvSource and @MethodSource for your test data.
 *
 * Example usage of mockMvc for a GET request
 * mockMvc.perform(get("/path-to-your-endpoint").param("your-query-param", param-value))
 *                 .andExpect(status().whateverStatusCodeYouExpect())
 *                 .andExpect(content().string("string-you-expect-in-response")).
 *                 .andExpect(jsonPath("$.jsonField").value("json-value-you-expect"));
 */
@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource(
            {"eloquent, loquen",
            "country, ountr",
            "person, erso",
            "ab, ''",
            "xyz, y",
            "_123_%qwerty+, 123_%qwerty"}
    )
    public void shouldReturnResponseOk(String input, String output) throws Exception {
        mockMvc.perform(get("/demo/api/v1/remove").param("input", input))
                .andExpect(status().isOk())
                .andExpect(content().string(output));
    }

    @Test
    public void shouldReturnBadResponse() throws Exception {
        mockMvc.perform(get("/demo/api/v1/remove").param("input", "a"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnBadResponseForEmptyInput() throws Exception {
        mockMvc.perform(get("/demo/api/v1/remove").param("input", ""))
                .andExpect(status().isBadRequest());
    }
    // add your test cases here
}
