package com.ite.spring.rest.api.service.impl;

import com.ite.spring.rest.api.domain.Coffee;
import com.ite.spring.rest.api.dto.CoffeeResponse;
import com.ite.spring.rest.api.dto.CreateCoffeeRequest;
import com.ite.spring.rest.api.dto.UpdateCoffeeRequest;
import com.ite.spring.rest.api.repository.CoffeeRepository;
import com.ite.spring.rest.api.service.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Random;

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
//        List<Coffee> coffees = coffeeRepository.beanCoffee();
//        return dto - coffeeResponse
        return coffeeRepository.getCoffeeBeans()
                .stream()
//                .filter(coffee -> coffee.getCode()> 2)
                .map(coffee -> new CoffeeResponse(coffee.getId(),coffee.getName(), coffee.getDescription(),coffee.getPrice()))
                .toList();
    }

    @Override
    public CoffeeResponse getCoffeeById(Long id) {

//        List<Coffee> coffees = coffeeRepository.beanCoffee();

        return coffeeRepository.getCoffeeBeans()
                .stream()
                .filter(coffee -> coffee.getId().equals(id))
                .map(coffee -> new CoffeeResponse(coffee.getId(),coffee.getName(), coffee.getDescription(),coffee.getPrice()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CoffeeResponse> searchCoffeeByName(String name) {
//        List<Coffee> coffees = coffeeRepository.beanCoffee();

        return coffeeRepository.getCoffeeBeans()
                .stream()
                .filter(coffee -> coffee.getName().toLowerCase().contains(name.toLowerCase()))
                .map(coffee -> new CoffeeResponse(coffee.getId(),coffee.getName(), coffee.getDescription(),coffee.getPrice()))
                .toList();
    }

    @Override
    public List <CoffeeResponse> searchCoffeeByPrice(Double price) {
//        List<Coffee> coffees = coffeeRepository.beanCoffee();

        return coffeeRepository.getCoffeeBeans()
                        .stream()
                .filter(coffee -> Objects.equals(coffee.getPrice(), price))
                .map(coffee -> new CoffeeResponse(coffee.getId(),coffee.getName(), coffee.getDescription(),coffee.getPrice()))
                .toList();
    }

    @Override
    public CoffeeResponse createCoffee(CreateCoffeeRequest createCoffeeRequest) {
        Coffee coffee = new Coffee();

        coffee.setId(new Random().nextLong(999999));
        coffee.setName(createCoffeeRequest.name());
        coffee.setDescription(createCoffeeRequest.description());
        coffee.setPrice(createCoffeeRequest.price());

        boolean isExisting = coffeeRepository.getCoffeeBeans()
                .stream()
                .anyMatch(c -> c.getId().equals(coffee.getId()));

        if (isExisting) {
            throw new RuntimeException("Coffee ID already exists");
        }

        coffeeRepository.getCoffeeBeans().add(coffee);

        return new CoffeeResponse(coffee.getId(),coffee.getName(), coffee.getDescription(), coffee.getPrice());
    }

    @Override
    public CoffeeResponse updateCoffeeById(Long id, UpdateCoffeeRequest updateCoffeeRequest) {

//        validate coffee id exist or not
        return coffeeRepository.getCoffeeBeans()
                .stream()
                .filter(coffee -> coffee.getId().equals(id))
                .findFirst()
                .map(oldCoffee-> {
                    oldCoffee.setName(updateCoffeeRequest.name());
                    oldCoffee.setDescription(updateCoffeeRequest.description());
                    oldCoffee.setPrice(updateCoffeeRequest.price());

                    return oldCoffee;
                } )
                .map(newCoffee-> new CoffeeResponse(newCoffee.getId(), newCoffee.getName(), newCoffee.getDescription(), newCoffee.getPrice()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Coffee with id %s does not exist in database", id)));

    }

    @Override
    public void deleteCoffeeById(Long id) {

        Coffee coffee = coffeeRepository.getCoffeeBeans()
                .stream()
                .filter(c-> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Coffee with id %s does not exist in database", id)));

        coffeeRepository.getCoffeeBeans().remove(coffee);
    }

}
