package com.yank.pruebaMongoDb.mapper;

import java.util.List;

import com.yank.pruebaMongoDb.dto.common.AddressDto;
import com.yank.pruebaMongoDb.dto.request.UserRequest;
import com.yank.pruebaMongoDb.dto.response.UserResponse;
import com.yank.pruebaMongoDb.model.Address;
import com.yank.pruebaMongoDb.model.User;

public class UserMapper {
    public static User toEntity(UserRequest request) {
        return User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .address(toAddressEntity(request.getAddress()))
                .build();
    }

    public static Address toAddressEntity(AddressDto dto) {
        return Address.builder()
                .street(dto.getStreet())
                .city(dto.getCity())
                .country(dto.getCountry())
                .zipCode(dto.getZipCode())
                .build();
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .address(toAddressDto(user.getAddress()))
                .build();
    }

    public static AddressDto toAddressDto(Address address) {
        return new AddressDto(
                address.getStreet(),
                address.getCity(),
                address.getCountry(),
                address.getZipCode());
    }

    public static List<UserResponse> toResponseList(List<User> users) {
        return users.stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
