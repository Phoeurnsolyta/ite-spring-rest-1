package com.ite.spring.rest.api.service;

import com.ite.spring.rest.api.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {

    List<CoffeeResponse> getCoffees();

    CoffeeResponse getCoffeeById(Long id);

    List <CoffeeResponse> searchCoffeeByName(String name);

    List <CoffeeResponse> searchCoffeeByPrice(Double price);

}
