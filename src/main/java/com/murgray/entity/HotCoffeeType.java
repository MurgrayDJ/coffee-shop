package com.murgray.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HotCoffeeType {
    
    @Id
    private Long typeId;
    private String coffeeType;
    @ManyToOne
    @JoinColumn(name = "milk_type_id")
    private MilkType milkType;
    
    // getters and setters
}