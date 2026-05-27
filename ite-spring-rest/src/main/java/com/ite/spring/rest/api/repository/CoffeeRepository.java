package com.ite.spring.rest.api.repository;

import com.ite.spring.rest.api.domain.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepository {

    @Bean
    public List<Coffee> beanCoffee() {
        Coffee coffee = new Coffee(1,"Ice latte","30%");
        Coffee coffee2 = new Coffee(2,"Hot Mocha","25%");
        Coffee coffee3 = new Coffee(3,"Matcha coffee latte","50%");
        return Arrays.asList(coffee,coffee2,coffee3);
    }
}
