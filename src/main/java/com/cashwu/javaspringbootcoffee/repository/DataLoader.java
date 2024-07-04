package com.cashwu.javaspringbootcoffee.repository;

import com.cashwu.javaspringbootcoffee.model.Coffee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cash.wu
 * @since 2024/07/04
 */
@Component
public class DataLoader {

    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadCoffees() {

        this.coffeeRepository.saveAll(
                List.of(new Coffee("Latte"), new Coffee("Espresso"), new Coffee("Americano"),
                        new Coffee("Cappuccino"), new Coffee("Mocha")));

    }
}
