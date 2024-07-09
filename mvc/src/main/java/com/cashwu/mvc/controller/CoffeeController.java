package com.cashwu.mvc.controller;

import com.cashwu.mvc.model.Coffee;
import com.cashwu.mvc.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author cash.wu
 * @since 2024/07/09
 */
@Controller
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeRepository coffeeRepository;

    @GetMapping("/coffee")
    public String getCoffee(Model model) {

        model.addAttribute("coffee", coffeeRepository.findAll());

        return "coffee";
    }
}
