package com.ite.spring.rest.api.dto;

public record CoffeeResponse(
        String name,
        String description,
        Double price
) {
}
