package com.salatin.carrepairuserservice.service;

import com.salatin.carrepairuserservice.exception.UserAlreadyExistsException;
import com.salatin.carrepairuserservice.model.User;
import com.salatin.carrepairuserservice.model.dto.request.RegistrationRequestDto;
import com.salatin.carrepairuserservice.model.dto.response.RegistrationResponseDto;
import com.salatin.carrepairuserservice.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final UserMapper userMapper;

    public RegistrationResponseDto registerCustomer(RegistrationRequestDto request) {
        checkIfUserNotAlreadyExists(request.getEmail());

        User user = userMapper.toUser(request);
        user = userService.save(user);

        return new RegistrationResponseDto(
                user.getId(), "User was registered successfully."
        );
    }

    private void checkIfUserNotAlreadyExists(String email) {
        if (userService.findByEmail(email) != null) {
            throw new UserAlreadyExistsException(
                    String.format("User with email %s is already exists!", email)
            );
        }
    }
}
