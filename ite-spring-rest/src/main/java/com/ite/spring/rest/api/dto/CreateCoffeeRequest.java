package com.ite.spring.rest.api.dto;

import jakarta.validation.constraints.*;

public record CreateCoffeeRequest(

        @NotBlank(message = "Name is required!")
        @Size(min = 3, max = 200)
        String name,

        @NotBlank(message = "Description is required!")
        @Size(min = 5, max = 10000)
        String description,

        @NotNull(message = "Price is required!")
        @Positive (message = "price cannot be negative!")
        Double price
) {
}
