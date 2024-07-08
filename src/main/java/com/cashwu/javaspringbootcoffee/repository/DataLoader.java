package com.cashwu.javaspringbootcoffee.repository;

import com.cashwu.javaspringbootcoffee.model.Coffee;
import com.cashwu.javaspringbootcoffee.model.Photo;
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
    private final PhotoRepository photoRepository;

    public DataLoader(CoffeeRepository coffeeRepository,
                      PhotoRepository photoRepository) {
        this.coffeeRepository = coffeeRepository;
        this.photoRepository = photoRepository;
    }

    @PostConstruct
    private void loadCoffees() {

//        this.coffeeRepository.saveAll(
//                List.of(new Coffee("Latte"), new Coffee("Espresso"), new Coffee("Americano"),
//                        new Coffee("Cappuccino"), new Coffee("Mocha")));
        Photo photo = new Photo("title", "https://via.placeholder.com/600/24f355",
                                "https://via.placeholder.com/600/24f355");
        this.photoRepository.save(photo);

    }
}
