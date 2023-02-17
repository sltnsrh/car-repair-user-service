package com.salatin.userservice.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.salatin.userservice.exception.UserAlreadyExistsException;
import com.salatin.userservice.model.User;
import com.salatin.userservice.repository.UserRepository;
import com.salatin.userservice.service.RegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class RegistrationControllerIntegrationTest extends IntegrationTest {

    private static final String USERNAME = "test@mail.com";

    private User user;

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        user = new User();
        user.setEmail(USERNAME);
    }

    @Test
    void registerWithNewUsernameShouldReturnUserWithId() {
        User registredUser = registrationService.registerCustomer(new User());

        assertNotNull(registredUser.getId());
    }

    @Test
    void registerWithExistingUsernameShouldThrowException() {
        userRepository.save(user);

        assertThrows(UserAlreadyExistsException.class,
                () -> registrationService.registerCustomer(user));
    }
}
