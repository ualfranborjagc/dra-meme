package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "favoritos")
public class Favoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameFav;
    
    @JsonIgnore
    @OneToMany(mappedBy = "favoritos", cascade = CascadeType.ALL)
    private List<Meme> memes;
    public Favoritos() {
    }
    public Favoritos(Long id, String nameFav, List<Meme> memes) {
        this.id = id;
        this.nameFav = nameFav;
        this.memes = memes;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameFav() {
        return nameFav;
    }
    public void setNameFav(String nameFav) {
        this.nameFav = nameFav;
    }
    public List<Meme> getMemes() {
        return memes;
    }
    public void setMemes(List<Meme> memes) {
        this.memes = memes;
    }

    public void agregarMeme(Meme meme) {
        memes.add(meme);
        meme.setFavoritos(this);
    }

    public void eliminarMeme(Meme meme) {
        memes.remove(meme);
        meme.setFavoritos(this);
    }
    
}

