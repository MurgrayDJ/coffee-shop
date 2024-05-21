package com.murgray.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hot_coffee")
public class HotCoffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @Column(unique = true, nullable = false)
    private String coffeeType;

    @Column(nullable = false)
    private Boolean hasCoffee;

    @Column(nullable = false)
    private Boolean hasEspresso;

    @Column(nullable = false)
    private Boolean hasOtherIngredients;

    @ManyToOne
    @JoinColumn(name = "milk_type_id")
    private Milk milkType;

    @ManyToOne
    @JoinColumn(name = "texture_id")
    private MilkTexture milkTexture;

    // Getters and Setters

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public Boolean getHasCoffee() {
        return hasCoffee;
    }

    public void setHasCoffee(Boolean hasCoffee) {
        this.hasCoffee = hasCoffee;
    }

    public Boolean getHasEspresso() {
        return hasEspresso;
    }

    public void setHasEspresso(Boolean hasEspresso) {
        this.hasEspresso = hasEspresso;
    }

    public Boolean getHasOtherIngredients() {
        return hasOtherIngredients;
    }

    public void setHasOtherIngredients(Boolean hasOtherIngredients) {
        this.hasOtherIngredients = hasOtherIngredients;
    }

    public Milk getMilkType() {
        return milkType;
    }

    public void setMilkType(Milk milkType) {
        this.milkType = milkType;
    }

    public MilkTexture getMilkTexture() {
        return milkTexture;
    }

    public void setMilkTexture(MilkTexture milkTexture) {
        this.milkTexture = milkTexture;
    }
}
