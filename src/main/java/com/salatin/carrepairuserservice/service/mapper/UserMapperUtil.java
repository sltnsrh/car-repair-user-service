package com.salatin.carrepairuserservice.service.mapper;

import com.salatin.carrepairuserservice.model.status.UserRole;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperUtil {
    private final PasswordEncoder passwordEncoder;

    @Named("setEncodedPassword")
    String setEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Named("setCustomerRole")
    UserRole setCustomerRole(String value) {
        return UserRole.CUSTOMER;
    }
}
