package org.example.springtest.controller;

import org.example.springtest.model.entity.User;
import org.example.springtest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerStandAloneTest {
//    private MockMvc mockMvc;
//    @BeforeEach
//    void setUp() {
//        UserService fakeService = id -> new User(id, "leang");
//        UserController controller = new UserController(fakeService);
//        mockMvc = MockMvcBuilders.standaloneSetup(controller)
//                .build();
//    }
//
//    @Test
//    void getUserById() throws Exception {
//        mockMvc.perform(get("/api/v1/users/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("leang"));
//    }
}
