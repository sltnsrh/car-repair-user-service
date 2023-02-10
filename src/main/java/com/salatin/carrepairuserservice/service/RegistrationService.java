package com.salatin.carrepairuserservice.service;

import com.salatin.carrepairuserservice.model.User;
import com.salatin.carrepairuserservice.model.dto.request.RegistrationRequest;
import com.salatin.carrepairuserservice.model.dto.response.RegistrationResponse;
import com.salatin.carrepairuserservice.model.status.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserService userService;

    public RegistrationResponse register(RegistrationRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMobile(request.getMobile());
        user.setRole(UserRole.CUSTOMER);

        user = userService.save(user);

        RegistrationResponse response = new RegistrationResponse(
                user.getEmail(), "User registered successfully."
        );
        return response;
    }
}
