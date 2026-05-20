package com.yank.pruebaMongoDb.mapper;

import java.time.LocalDateTime;
import java.util.List;

import com.yank.pruebaMongoDb.dto.request.ProductCreateRequest;
import com.yank.pruebaMongoDb.dto.response.ProductResponse;
import com.yank.pruebaMongoDb.model.Product;

public class ProductMapper {
    public static Product toEntity(ProductCreateRequest request) {
        return Product.builder()
                .name(request.name())
                .category(request.category())
                .price(request.price())
                .stock(request.stock())
                .tags(request.tags())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .stock(product.getStock())
                .tags(product.getTags())
                .build();
    }

    public static List<ProductResponse> toResponsList(List<Product> products) {
        return products.stream().map(ProductMapper::toResponse).toList();
    }
}
