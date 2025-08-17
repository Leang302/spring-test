package org.example.springtest.controller;

import org.example.springtest.model.entity.Product;
import org.example.springtest.model.entity.User;
import org.example.springtest.service.ProductService;
import org.example.springtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest({UserController.class, ProductController.class})
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;
    @MockitoBean
    private ProductService productService;

    @Test
    void testGetUserById() throws Exception {
        when(userService.getUserById(1L))
                .thenReturn(new User(1L, "leang"));

        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("leang"));
    }
    @Test
    void testGetProductById() throws Exception{
        when(productService.getProductById(1L))
                .thenReturn(new Product(1L, "Cola"));
        mockMvc.perform(get("/api/v1/products/{id}",1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Cola"));
    }
}
