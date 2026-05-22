package com.yank.pruebaMongoDb.dto.response;

import com.yank.pruebaMongoDb.dto.common.AddressDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String id;
    
    private String email;

    private String name;

    private String lastName;

    private String phone;

    private AddressDto address;
}
