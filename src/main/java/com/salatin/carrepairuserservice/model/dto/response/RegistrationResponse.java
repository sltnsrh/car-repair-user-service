package com.salatin.carrepairuserservice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegistrationResponse {
    private String email;
    private String message;
}
