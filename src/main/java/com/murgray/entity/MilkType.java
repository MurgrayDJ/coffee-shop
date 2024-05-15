package com.murgray.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MilkType {
    
    @Id
    private Long milkTypeId;
    private String milkType;
    
    // getters and setters
}