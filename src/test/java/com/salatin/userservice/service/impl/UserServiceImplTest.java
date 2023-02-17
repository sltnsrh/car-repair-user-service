package com.salatin.userservice.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.salatin.userservice.model.User;
import com.salatin.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    public static final String USERNAME = "test@mail.com";
    public static final String USER_ID = "id";

    private User savedUser;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        savedUser = new User();
        savedUser.setId(USER_ID);
        savedUser.setEmail(USERNAME);
    }

    @Test
    void saveUserShouldReturnUser() {
        User userBeforeSave = new User();

        when(userRepository.save(userBeforeSave)).thenReturn(savedUser);

        assertNotNull(userService.save(userBeforeSave));
    }

    @Test
    void findByEmailShouldReturnUser() {
        when(userRepository.findUserByEmail(USERNAME)).thenReturn(savedUser);

        assertNotNull(userService.findByEmail(USERNAME));
    }
}