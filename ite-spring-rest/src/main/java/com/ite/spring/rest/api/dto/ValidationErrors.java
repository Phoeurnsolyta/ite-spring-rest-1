package com.ite.spring.rest.api.dto;

public record ValidationErrors(
        String field,
        String message
) {
}
