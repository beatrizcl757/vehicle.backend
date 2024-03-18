package com.beatriz.crud.backend.mappers;

import com.beatriz.crud.backend.dtos.SignUpDto;
import com.beatriz.crud.backend.dtos.UserDto;
import com.beatriz.crud.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
