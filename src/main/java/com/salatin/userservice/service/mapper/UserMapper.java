package com.salatin.userservice.service.mapper;

import com.salatin.userservice.model.User;
import com.salatin.userservice.model.dto.request.RegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapperUtil.class})
@RequiredArgsConstructor
public abstract class UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "password", target = "password", qualifiedByName = "setEncodedPassword")
    @Mapping(source = "role", target = "role", qualifiedByName = "setCustomerRole")
    @Mapping(source = "mobile", target = "mobile", qualifiedByName = "setMobile")
    public abstract User toCustomerUser(RegistrationRequestDto request);
}
