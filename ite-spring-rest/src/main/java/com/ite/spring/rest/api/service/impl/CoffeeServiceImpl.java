package com.ite.spring.rest.api.service.impl;

import com.ite.spring.rest.api.domain.Coffee;
import com.ite.spring.rest.api.dto.CoffeeResponse;
import com.ite.spring.rest.api.repository.CoffeeRepository;
import com.ite.spring.rest.api.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

//    depend on repo

    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }
    @Override
    public List<CoffeeResponse> getCoffees() {
//        retrieve domain from repository
        List<Coffee> coffees = coffeeRepository.beanCoffee();
//        return dto - coffeeResponse
        return coffees.stream()
//                .filter(coffee -> coffee.getCode()> 2)
                .map(coffee -> new CoffeeResponse(coffee.getName(), coffee.getDescription()))
                .toList();
    }
}
