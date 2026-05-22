package com.yank.pruebaMongoDb.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank(message = "Product name cannot be empty")
        @Size(min = 1, max = 100, message = "Product name must be between 1 and 100 characters")
        String name,

        @NotBlank(message = "Category cannot be empty")
        @Size(min = 1, max = 50, message = "Category must be between 1 and 50 characters")
        String category,

        @NotNull(message = "Price cannot be null")
        @Positive(message = "Price cannot be negative")
        Double price,

        @NotNull(message = "Stock cannot be null")
        @Positive(message = "Stock cannot be negative")
        Integer stock,

        @NotNull(message = "Tags cannot be null")
        @Size(max = 10, message = "Maximum 10 tags allowed")
        List<String> tags) {
}
