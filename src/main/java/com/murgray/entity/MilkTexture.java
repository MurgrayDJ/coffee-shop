package com.murgray.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "milk_texture")
public class MilkTexture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long textureId;

    @Column(nullable = false)
    private String texture;

    // Getters and Setters

    public Long getTextureId() {
        return textureId;
    }

    public void setTextureId(Long textureId) {
        this.textureId = textureId;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
}

