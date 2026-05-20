package com.yank.pruebaMongoDb.dto.request;

import com.yank.pruebaMongoDb.validation.ValidRange;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidRange(
    minField = "minPrice",
    maxField = "maxPrice",
    message = "The minimum price must be less than or equal to the maximum price"
)
public class PriceRangeRequest {
    @NotNull(message = "Min price cannot be null")
    @Positive(message = "Min price cannot be negative")
    private Double minPrice;

    @NotNull(message = "Max price cannot be null")
    @Positive(message = "Max price cannot be negative")
    private Double maxPrice;
}
