package com.yank.pruebaMongoDb.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
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
@Document(collection = "products")
public class Product {
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("category")
    private String category;

    @Field("price")
    private Double price;

    @Field("stock")
    private Integer stock;

    @Builder.Default
    @Field("active")
    private Boolean active = true;

    @Field("tags")
    private List<String> tags;

    @CreatedDate
    @Field("createdAt")
    private LocalDateTime createdAt;

    @CreatedDate
    @Field("updatedAt")
    private LocalDateTime updatedAt;
}
