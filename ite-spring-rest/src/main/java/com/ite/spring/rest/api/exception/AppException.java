package com.ite.spring.rest.api.exception;

import com.ite.spring.rest.api.dto.ValidationErrors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class AppException {

//    use responseEntity to custom from web
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e) {

        List<ValidationErrors> errors = new ArrayList<>();

        e.getFieldErrors().forEach(fieldError -> {
            errors.add(new ValidationErrors(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            ));
        });

        Map<String , Object> res = new HashMap<>();
        res.put("status", false);
        res.put("code", HttpStatus.BAD_REQUEST.value());
        res.put("message", "Validation is errored");
        res.put("errors", errors);

        return ResponseEntity.badRequest().body(res);
    }

}
