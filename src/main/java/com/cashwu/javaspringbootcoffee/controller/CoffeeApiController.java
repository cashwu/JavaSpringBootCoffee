package com.cashwu.javaspringbootcoffee.controller;

import com.cashwu.javaspringbootcoffee.model.Coffee;
import com.cashwu.javaspringbootcoffee.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author cash.wu
 * @since 2024/07/03
 */
@RestController
public class CoffeeApiController {

    private final CoffeeRepository coffeeRepository;

    public CoffeeApiController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    //get all coffee
    @GetMapping("/coffees")
    public Iterable<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    //get coffee by id
    @GetMapping("/coffees/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable String id) {

        return coffeeRepository.findById(id);
    }

    //add a new coffee api
    @PostMapping("/coffees")
    public Coffee addCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    //update coffee, not the coffee need to add one
    @PutMapping("/coffees/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable String id,
                                               @RequestBody Coffee coffee) {

        HttpStatus httpStatus;

        if (coffeeRepository.existsById(id)) {
            httpStatus = HttpStatus.OK;
        }
        else {
            httpStatus = HttpStatus.CREATED;
        }

        return new ResponseEntity<>(coffeeRepository.save(coffee), httpStatus);
    }

    //delete coffee
    @DeleteMapping("/coffees/{id}")
    public void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteById(id);
    }
}
