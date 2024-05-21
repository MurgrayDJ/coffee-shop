package com.murgray.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import com.murgray.entity.HotCoffee;
import com.murgray.repository.*;
 
@Controller
public class CoffeeShopController {
 
    private final CoffeeRepository coffeeRepository; 
 
    public CoffeeShopController(CoffeeRepository coffeeRepository) { 
        this.coffeeRepository = coffeeRepository; 
    }
 
    // @GetMapping("/")
    // public String index(Model model) {
    //     List<Object[]> coffeeTypes = coffeeRepository.findCoffeeTypes();
    //     model.addAttribute("coffeeTypes", coffeeTypes);
    //     return "index";
    // }
    
    @GetMapping("/")
    public String index(Model model) {
        List<HotCoffee> hotCoffees = coffeeRepository.findAllHotCoffee();
        model.addAttribute("hotCoffees", hotCoffees);
        return "index";
    }
}