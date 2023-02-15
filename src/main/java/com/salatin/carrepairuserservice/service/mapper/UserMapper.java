package com.salatin.carrepairuserservice.service.mapper;

import com.salatin.carrepairuserservice.model.User;
import com.salatin.carrepairuserservice.model.dto.request.RegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapperUtil.class})
@RequiredArgsConstructor
public abstract class UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "password", target = "password", qualifiedByName = "setEncodedPassword")
    @Mapping(source = "role", target = "role", qualifiedByName = "setCustomerRole")
    public abstract User toCustomerUser(RegistrationRequestDto request);
}
