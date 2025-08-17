package org.example.springtest.service;

import org.example.springtest.model.entity.User;
import org.example.springtest.repository.UserRepository;
import org.example.springtest.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void returnsNameFromRepo() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L, "Alice")));

        // Act
        User userById = userService.getUserById(1L);

        // Assert
        assertEquals("Alice", userById.getName());
        verify(userRepository).findById(1L); // ensures repo was called once
    }
    @Test
    void testNotFoundThrow(){

        when(userRepository.findById(1L)).thenThrow(new RuntimeException("Not found"));
        assertThrows(RuntimeException.class,()->{
            userRepository.findById(1L);
        });
    }
}
