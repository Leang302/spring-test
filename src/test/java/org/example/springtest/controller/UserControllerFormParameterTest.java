package org.example.springtest.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerFormParameterTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    @SneakyThrows
    void testCreateUser(){
        mockMvc.perform(post("/api/v1/users")
                        .param("name", "John"))
                        .andExpect(jsonPath("$.name").value("John"));

    }
}
