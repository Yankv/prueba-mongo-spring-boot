package com.yank.pruebaMongoDb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
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
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    @Field("email")
    private String email;

    @Field("name")
    private String name;

    @Field("lastName")
    private String lastName;

    @Field("phone")
    private String phone;

    // Embedded document for address
    @Field("address")
    private Address address;

    // Default value for active field
    @Builder.Default
    @Field("active")
    private Boolean active = true;
}
