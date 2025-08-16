package org.example.springtest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springtest.model.entity.User;
import org.example.springtest.repository.UserRepository;
import org.example.springtest.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
