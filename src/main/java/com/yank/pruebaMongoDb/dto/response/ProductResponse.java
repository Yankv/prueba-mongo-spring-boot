package com.yank.pruebaMongoDb.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private String id;

    private String name;

    private String category;

    private Double price;

    private Integer stock;

    private List<String> tags;
}
