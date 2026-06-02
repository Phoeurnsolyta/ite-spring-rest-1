package com.ite.spring.rest.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateCoffeeRequest(
        @NotBlank(message = "Name is required!")
        @Size(min = 3, max = 200)
        String name,

        @NotBlank(message = "Description is required!")
        @Size(min = 5, max = 10000)
        String description,

        @NotNull(message = "Price is required!")
        @Positive(message = "price cannot be negative!")
        Double price
) {
}
