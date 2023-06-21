
package com.example.demo.controller;

import com.example.demo.entity.Meme;
import com.example.demo.entity.Favoritos;
import com.example.demo.repository.MemeRepository;
import com.example.demo.repository.FavoritosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemeController {

    private final MemeRepository memeRepository;
    private final FavoritosRepository favoritosRepository;

    @Autowired
    public MemeController(MemeRepository memeRepository, FavoritosRepository favoritosRepository) {
        this.memeRepository = memeRepository;
        this.favoritosRepository = favoritosRepository;
    }

    // Endpoint para obtener todos los memes
    @GetMapping("/memes")
    public ResponseEntity<List<Meme>> getAllMemes() {
        List<Meme> memes = memeRepository.findAll();
        return new ResponseEntity<>(memes, HttpStatus.OK);
    }

    // Endpoint para obtener un meme por ID
    @GetMapping("/memes/{id}")
    public ResponseEntity<Meme> getMemeById(@PathVariable Long id) {
        Meme meme = memeRepository.findById(id).orElse(null);
        if (meme != null) {
            return new ResponseEntity<>(meme, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo meme
    @PostMapping("/memes")
    public ResponseEntity<Meme> createMeme(@RequestBody Meme meme) {
        Meme newMeme = memeRepository.save(meme);
        return new ResponseEntity<>(newMeme, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un meme existente
    @PostMapping("/memes/{id}")
    public ResponseEntity<Meme> updateMeme(@PathVariable Long id, @RequestBody Meme updatedMeme) {
        Meme meme = memeRepository.findById(id).orElse(null);
        if (meme != null) {
            meme.setImageUrl(updatedMeme.getImageUrl());
            meme.setFavoritos(updatedMeme.getFavoritos());
            Meme updatedMemeObj = memeRepository.save(meme);
            return new ResponseEntity<>(updatedMemeObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un meme por ID
    @DeleteMapping("/memes/{id}")
    public ResponseEntity<Void> deleteMeme(@PathVariable Long id) {
        Meme meme = memeRepository.findById(id).orElse(null);
        if (meme != null) {
            memeRepository.delete(meme);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para obtener todos los favoritos
    @GetMapping("/favoritos")
    public ResponseEntity<List<Favoritos>> getAllFavoritos() {
        List<Favoritos> favoritos = favoritosRepository.findAll();
        return new ResponseEntity<>(favoritos, HttpStatus.OK);
    }

    // Endpoint para obtener un favorito por ID
    @GetMapping("/favoritos/{id}")
    public ResponseEntity<Favoritos> getFavoritosById(@PathVariable Long id) {
        Favoritos favoritos = favoritosRepository.findById(id).orElse(null);
        if (favoritos != null) {
            return new ResponseEntity<>(favoritos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo favorito
    @PostMapping("/favoritos")
    public ResponseEntity<Favoritos> createFavoritos(@RequestBody Favoritos favoritos) {
        Favoritos newFavoritos = favoritosRepository.save(favoritos);
        return new ResponseEntity<>(newFavoritos, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un favorito existente
    @PostMapping("/favoritos/{id}")
    public ResponseEntity<Favoritos> updateFavoritos(@PathVariable Long id, @RequestBody Favoritos updatedFavoritos) {
        Favoritos favoritos = favoritosRepository.findById(id).orElse(null);
        if (favoritos != null) {
            favoritos.setNameFav(updatedFavoritos.getNameFav());
            favoritos.setMemes(updatedFavoritos.getMemes());
            Favoritos updatedFavoritosObj = favoritosRepository.save(favoritos);
            return new ResponseEntity<>(updatedFavoritosObj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un favorito por ID
    @DeleteMapping("/favoritos/{id}")
    public ResponseEntity<Void> deleteFavoritos(@PathVariable Long id) {
        Favoritos favoritos = favoritosRepository.findById(id).orElse(null);
        if (favoritos != null) {
            favoritosRepository.delete(favoritos);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para obtener los memes de un favorito por ID
    @GetMapping("/favoritos/{favoritoId}/memes")
    public ResponseEntity<List<Meme>> getMemesByFavoritoId(@PathVariable Long favoritoId) {
        Favoritos favoritos = favoritosRepository.findById(favoritoId).orElse(null);
        if (favoritos != null) {
            List<Meme> memes = favoritos.getMemes();
            return new ResponseEntity<>(memes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/{favoritoId}/favoritos")
    public ResponseEntity<Favoritos> agregarFavorito(
            @PathVariable Long favoritoId,
            @RequestBody Meme meme) {
        Favoritos favorito = favoritosRepository.findById(favoritoId).orElse(null);

        if (favorito != null) {
            favorito.agregarMeme(meme);
            favoritosRepository.save(favorito);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}