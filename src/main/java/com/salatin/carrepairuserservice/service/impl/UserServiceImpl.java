package com.salatin.carrepairuserservice.service.impl;

import com.salatin.carrepairuserservice.model.User;
import com.salatin.carrepairuserservice.repository.UserRepository;
import com.salatin.carrepairuserservice.service.UserService;
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
