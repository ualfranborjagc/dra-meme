package com.example.drameme.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Meme")
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    public Meme() {
    }

    public Meme(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Meme [id=" + id + "]";
    }
}
