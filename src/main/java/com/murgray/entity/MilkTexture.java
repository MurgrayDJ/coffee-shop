package com.murgray.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "milk_texture")
public class MilkTexture {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long textureId;

    @Column(nullable = false)
    private String texture;
    
    // getters and setters
}
