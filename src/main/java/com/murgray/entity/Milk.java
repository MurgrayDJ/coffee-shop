package com.murgray.entity;

import javax.persistence.*;

@Entity
@Table(name = "milk")
public class Milk {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long milkTypeId;

    @Column(unique = true, nullable = false)
    private String milkType;
    
    // getters and setters
}