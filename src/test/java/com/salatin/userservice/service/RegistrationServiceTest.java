package com.salatin.userservice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.salatin.userservice.exception.UserAlreadyExistsException;
import com.salatin.userservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {
    private static final String USERNAME = "test@mail.com";

    private User user;

    @InjectMocks
    private RegistrationService registrationService;

    @Mock
    private UserService userService;

    @BeforeEach
    void init() {
        user = new User();
        user.setEmail(USERNAME);
    }

    @Test
    void registerCustomerWithExistingUsernameExpectException() {
        Mockito.when(userService.findByEmail(USERNAME)).thenReturn(user);

        assertThrows(UserAlreadyExistsException.class,
                () ->registrationService.registerCustomer(user));
    }

    @Test
    void registerCustomerWithNewUsernameShouldReturnNotNull() {
        Mockito.when(userService.findByEmail(USERNAME)).thenReturn(null);
        Mockito.when(userService.save(user)).thenReturn(user);

        assertNotNull(registrationService.registerCustomer(user));
    }
}
