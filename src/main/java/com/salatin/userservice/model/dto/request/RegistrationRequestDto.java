package com.salatin.userservice.model.dto.request;

import com.salatin.userservice.validation.FieldsValueMatch;
import com.salatin.userservice.validation.ValidEmail;
import com.salatin.userservice.validation.ValidMobile;
import com.salatin.userservice.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[a-zA-Z]{2,30}$", message = "First name doesn't match")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z]{2,50}$", message = "Last name doesn't match")
    private String lastName;
    @ValidPassword
    private String password;
    @NotBlank(message = "Confirmation password field must not be empty")
    private String repeatPassword;
    @ValidMobile
    private String mobile;
    private String role;
}
