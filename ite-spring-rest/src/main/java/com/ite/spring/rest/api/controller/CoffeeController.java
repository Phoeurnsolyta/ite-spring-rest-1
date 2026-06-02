package com.ite.spring.rest.api.controller;

import com.ite.spring.rest.api.domain.Coffee;
import com.ite.spring.rest.api.dto.CoffeeResponse;
import com.ite.spring.rest.api.dto.CreateCoffeeRequest;
import com.ite.spring.rest.api.dto.UpdateCoffeeRequest;
import com.ite.spring.rest.api.service.CoffeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List <CoffeeResponse> getCoffees() {
        return coffeeService.getCoffees();
    }

    @GetMapping("/{id}")
//    use to catch data from URI,unique data
    public CoffeeResponse getCoffeeById(@PathVariable Long id ) {
        log.info("GET id: {}", id);
        return coffeeService.getCoffeeById(id);
    }

//    user for mark on parameter on mapping method,general data
    @GetMapping("/search")
    public List <CoffeeResponse> searchCoffeeByName(
            @RequestParam (required = false, defaultValue = "") String name
    ){
        log.info("Get search name: {}", name);

        return coffeeService.searchCoffeeByName(name);
    }

    @GetMapping("/price")
    public List <CoffeeResponse> searchCoffeeByPrice(
            @RequestParam (required = false, defaultValue = "0") @PathVariable Double price
    ){
        log.info("Get search price: {}", price);

        return coffeeService.searchCoffeeByPrice(price);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping

    public CoffeeResponse createCoffee(@Valid @RequestBody CreateCoffeeRequest createCoffeeRequest) {

//        log.info("Create coffee: {}", createCoffeeRequest);
        return coffeeService.createCoffee(createCoffeeRequest);
    }

    @PutMapping("/{id}")
    public CoffeeResponse updateCoffeeById(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCoffeeRequest updateCoffeeRequest
    ) {
        return coffeeService.updateCoffeeById(id, updateCoffeeRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCoffeeById(@PathVariable Long id) {
        coffeeService.deleteCoffeeById(id);

        log.info("Deleted coffee with id: {}", id);
    }


}
