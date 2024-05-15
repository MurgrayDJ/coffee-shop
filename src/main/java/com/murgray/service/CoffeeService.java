package com.murgray.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.murgray.repository.CoffeeRepository;

@Service
public class CoffeeService {
    
    private final CoffeeRepository coffeeRepository;
    
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }
    
    public List<Object[]> findCoffeeTypes() {
        return coffeeRepository.findCoffeeTypes();
    }
}