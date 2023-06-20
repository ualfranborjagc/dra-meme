package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "meme")
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "favoritos_id")
    private Favoritos favoritos;

    public Meme() {
    }

    public Meme(Long id, String imageUrl, Favoritos favoritos) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.favoritos = favoritos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Favoritos getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Favoritos favoritos) {
        this.favoritos = favoritos;
    }

    
}
