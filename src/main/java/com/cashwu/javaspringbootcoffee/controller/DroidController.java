package com.cashwu.javaspringbootcoffee.controller;

import com.cashwu.javaspringbootcoffee.model.config.Droid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cash.wu
 * @since 2024/07/05
 */
@RestController
@RequestMapping("/droid")
public class DroidController {

    private final Droid droid;

    public DroidController(Droid droid) {
        this.droid = droid;
    }

    @GetMapping
    Droid getDroid(){
       return droid;
    }
}
