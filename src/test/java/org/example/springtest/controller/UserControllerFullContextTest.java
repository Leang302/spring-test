package org.example.springtest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerFullContextTest {
    @Autowired MockMvc mvc;
    @Test
    void getUser_returnsOk() throws Exception {
        mvc.perform(get("/api/v1/users/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("leang"));
    }
    @Test
    void testGetProductById() throws Exception{
        mvc.perform(get("/api/v1/products/{id}",1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Cola"));
    }


}

