package com.salatin.userservice.controller;

import com.salatin.userservice.model.User;
import com.salatin.userservice.model.dto.request.RegistrationRequestDto;
import com.salatin.userservice.model.dto.response.RegistrationResponseDto;
import com.salatin.userservice.service.RegistrationService;
import com.salatin.userservice.service.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    private final UserMapper userMapper;

    @PostMapping(value = "/register")
    public ResponseEntity<RegistrationResponseDto> register(
            @Valid @RequestBody RegistrationRequestDto request) {
        User user = userMapper.toCustomerUser(request);
        User savedUser = registrationService.registerCustomer(user);
        return new ResponseEntity<>(
                createRegistrationSuccessResponse(savedUser),
                HttpStatus.CREATED
        );
    }

    private RegistrationResponseDto createRegistrationSuccessResponse(User savedUser) {
        return new RegistrationResponseDto(
                savedUser.getId(), "User was registered successfully."
        );
    }
}
