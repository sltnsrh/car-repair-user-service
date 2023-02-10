package com.salatin.carrepairuserservice.controller;

import com.salatin.carrepairuserservice.model.dto.request.RegistrationRequest;
import com.salatin.carrepairuserservice.model.dto.response.RegistrationResponse;
import com.salatin.carrepairuserservice.service.RegistrationService;
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
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
        return new ResponseEntity(registrationService.register(request), HttpStatus.CREATED);
    }
}
