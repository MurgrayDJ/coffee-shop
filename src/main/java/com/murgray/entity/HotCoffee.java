package com.murgray.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "hot_coffee")
public class HotCoffee {
    
    @Id
    private Long typeId;
    private String coffeeType;
    private Boolean hasCoffee;
    private Boolean hasEspresso;
    private Boolean hasOtherIngredients;
    @ManyToOne
    @JoinColumn(name = "milk_type_id")
    private Milk milkType;
    @ManyToOne
    @JoinColumn(name = "texture_id")
    private MilkTexture milkTexture;
    
    // getters and setters
}