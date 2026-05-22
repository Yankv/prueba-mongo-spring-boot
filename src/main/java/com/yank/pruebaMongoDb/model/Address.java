package com.yank.pruebaMongoDb.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// This class doesn't need @Document annotation since it's embedded in User
public class Address {
    @Field("street")
    private String street;

    @Field("city")
    private String city;

    @Field("country")
    private String country;

    @Field("zipCode")
    private String zipCode;
}
