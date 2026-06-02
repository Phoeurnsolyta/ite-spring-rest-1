package com.ite.spring.rest.api.exception;

import lombok.Builder;

@Builder
public record ValidationErrors (

        String field,
        String message

) {
}
