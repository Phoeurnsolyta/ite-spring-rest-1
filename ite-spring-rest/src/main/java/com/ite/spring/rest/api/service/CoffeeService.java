package com.ite.spring.rest.api.service;

import com.ite.spring.rest.api.dto.CoffeeResponse;
import com.ite.spring.rest.api.dto.CreateCoffeeRequest;
import com.ite.spring.rest.api.dto.UpdateCoffeeRequest;

import java.util.List;

public interface CoffeeService {

    List<CoffeeResponse> getCoffees();

    CoffeeResponse getCoffeeById(Long id);

    List <CoffeeResponse> searchCoffeeByName(String name);

    List <CoffeeResponse> searchCoffeeByPrice(Double price);

//    1. expected result (return type: void, object, collection,init,...)
//    2. your logic: addCoffee
//    3. Parameters is used for client submission
    CoffeeResponse createCoffee (CreateCoffeeRequest createCoffeeRequest);

//    1. is update coffee info by id
//    2. Expected result is updateCoffeeResponse
//    3. parameter is updateCOffeeRequest

    CoffeeResponse updateCoffeeById(Long id, UpdateCoffeeRequest updateCoffeeRequest);

    void deleteCoffeeById(Long id);


}
