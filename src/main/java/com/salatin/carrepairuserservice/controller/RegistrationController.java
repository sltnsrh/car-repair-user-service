package com.salatin.carrepairuserservice.controller;

import com.salatin.carrepairuserservice.model.dto.request.RegistrationRequestDto;
import com.salatin.carrepairuserservice.model.dto.response.RegistrationResponseDto;
import com.salatin.carrepairuserservice.service.RegistrationService;
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

    @PostMapping(value = "/register")
    public ResponseEntity<RegistrationResponseDto> register(
            @Valid @RequestBody RegistrationRequestDto request) {
        return new ResponseEntity(
                registrationService.registerCustomer(request),
                HttpStatus.CREATED
        );
    }
}
