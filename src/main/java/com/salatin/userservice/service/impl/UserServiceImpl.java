package com.salatin.userservice.service.impl;

import com.salatin.userservice.model.User;
import com.salatin.userservice.repository.UserRepository;
import com.salatin.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
