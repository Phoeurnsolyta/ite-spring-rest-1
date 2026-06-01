package com.ite.spring.rest.api.dto;

public record CoffeeResponse(

        Long id,
        String name,
        String description,
        Double price
) {
}
