package com.salatin.carrepairuserservice.model.dto.request;

import lombok.Getter;

@Getter
public class RegistrationRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String repeatPassword;
    private String mobile;
}
