package com.ite.spring.rest.api.repository;

import com.ite.spring.rest.api.domain.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepository {

    private final List<Coffee> coffeeBeans;


    public CoffeeRepository() {
        this.coffeeBeans = new ArrayList<>();
        Coffee coffee = new Coffee(1L,"Ice latte","30%",2.50);
        Coffee coffee2 = new Coffee(2L,"Hot Mocha","25%",3.00);
        Coffee coffee3 = new Coffee(3L,"Matcha coffee latte","50%",1.27);

        coffeeBeans.add(coffee);
        coffeeBeans.add(coffee2);
        coffeeBeans.add(coffee3);

    }


    public List<Coffee> getCoffeeBeans() {
        return coffeeBeans;
    }
}
