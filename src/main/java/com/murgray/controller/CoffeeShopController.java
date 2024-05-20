package com.murgray.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.murgray.service.CoffeeService;

@Controller
public class CoffeeShopController {
    
    private final CoffeeService coffeeService;

    public CoffeeShopController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Object[]> coffeeTypes = coffeeService.findCoffeeTypes();
        model.addAttribute("coffeeTypes", coffeeTypes);
        return "index";
    }
}
