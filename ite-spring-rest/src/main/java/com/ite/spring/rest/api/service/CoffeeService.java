package com.ite.spring.rest.api.service;

import com.ite.spring.rest.api.dto.CoffeeResponse;
import com.ite.spring.rest.api.dto.CreateCoffeeRequest;

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


}
