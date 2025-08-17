package org.example.springtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springtest.model.dto.request.UserRequest;
import org.example.springtest.model.entity.User;
import org.example.springtest.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @GetMapping("/{id}")
    public User get(@PathVariable long id) {

        return userService.getUserById(id);
    }
    @PostMapping
    public User get(@RequestParam String name) {
        return userService.createUser(name);
    }
}
