package com.murgray.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeShopController {
    
    @GetMapping("/")
    public String index() {
        return "Welcome to the Coffee Shop!";
    }
}
