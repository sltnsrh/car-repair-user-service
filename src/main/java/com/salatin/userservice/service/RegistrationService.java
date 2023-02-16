package com.salatin.userservice.service;

import com.salatin.userservice.exception.UserAlreadyExistsException;
import com.salatin.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserService userService;

    public User registerCustomer(User user) {
        checkIfUserNotAlreadyExists(user.getEmail());

        return userService.save(user);
    }

    private void checkIfUserNotAlreadyExists(String email) {
        if (userService.findByEmail(email) != null) {
            throw new UserAlreadyExistsException(
                    String.format("User with email %s is already exists!", email)
            );
        }
    }
}
