package com.yank.pruebaMongoDb.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private String id;

    private String name;

    private String category;

    private BigDecimal price;

    private Integer stock;

    private Boolean active;

    private List<String> tags;
}
