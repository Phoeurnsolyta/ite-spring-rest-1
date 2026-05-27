package com.ite.spring.rest.api.controller;

import com.ite.spring.rest.api.dto.CoffeeResponse;
import com.ite.spring.rest.api.service.CoffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoffeeController {

    private final CoffeeService coffeeService;
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/v1/coffees")
    public List <CoffeeResponse> getCoffees() {
        return coffeeService.getCoffees();
    }
}
