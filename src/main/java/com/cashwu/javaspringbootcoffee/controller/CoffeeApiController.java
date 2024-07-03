package com.cashwu.javaspringbootcoffee.controller;

import com.cashwu.javaspringbootcoffee.model.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author cash.wu
 * @since 2024/07/03
 */
@RestController
public class CoffeeApiController {

    private final List<Coffee> coffees = new ArrayList<>();

    public CoffeeApiController() {
        coffees.addAll(List.of(new Coffee("Latte"),
                               new Coffee("Espresso"),
                               new Coffee("Americano"),
                               new Coffee("Cappuccino"),
                               new Coffee("Mocha")));
    }

    //get all coffee
    @GetMapping("/coffees")
    public List<Coffee> getAllCoffees() {
        return coffees;
    }

    //get coffee by id
    @GetMapping("/coffees/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable String id) {

        for (Coffee coffee : coffees) {
            if (coffee.getId().equals(id)) {
                return Optional.of(coffee);
            }
        }

        return Optional.empty();
    }

    //add a new coffee api
    @PostMapping("/coffees")
    public Coffee addCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }

    //update coffee, not the coffee need to add one
    @PutMapping("/coffees/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable String id,
                                               @RequestBody Coffee coffee) {

        int coffeeIndex = -1;
        for (Coffee currentCoffee : coffees) {
            if (currentCoffee.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(currentCoffee);
                coffees.set(coffeeIndex, coffee);
            }
        }

        // add coffee
        return coffeeIndex == -1 ?
                new ResponseEntity<>(addCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    //delete coffee
    @DeleteMapping("/coffees/{id}")
    public void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(coffee -> coffee.getId().equals(id));
    }
}
