package com.salatin.carrepairuserservice.model.dto.request;

import com.salatin.carrepairuserservice.validation.FieldsValueMatch;
import com.salatin.carrepairuserservice.validation.ValidEmail;
import com.salatin.carrepairuserservice.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match"
)
public class RegistrationRequestDto {
    @ValidEmail
    private String email;
    private String firstName;
    private String lastName;
    @ValidPassword
    private String password;
    @NotBlank(message = "Confirmation password field must not be empty")
    private String repeatPassword;
    private String mobile;
}
