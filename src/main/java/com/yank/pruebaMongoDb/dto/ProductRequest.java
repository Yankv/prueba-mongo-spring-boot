package com.yank.pruebaMongoDb.dto;

import java.math.BigDecimal;
import java.util.List;
import jakarta.validation.constraints.*;

public record ProductRequest(
        @NotBlank(message = "Product name cannot be empty")
        @Size(min = 1, max = 100, message = "Product name must be between 1 and 100 characters")
        String name,

        @NotBlank(message = "Category cannot be empty")
        @Size(min = 1, max = 50, message = "Category must be between 1 and 50 characters")
        String category,

        @NotNull(message = "Price cannot be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
        @Digits(integer = 10, fraction = 2, message = "Price must have up to 10 integer digits and 2 decimal places")
        BigDecimal price,

        @NotNull(message = "Stock cannot be null")
        @Min(value = 0, message = "Stock cannot be negative")
        Integer stock,

        @NotNull(message = "Active status cannot be null")
        Boolean active,

        @NotNull(message = "Tags cannot be null")
        @Size(max = 10, message = "Maximum 10 tags allowed")
        List<String> tags) {
}
