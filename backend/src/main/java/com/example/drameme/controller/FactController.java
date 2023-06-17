package com.example.drameme.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.drameme.entity.Fact;

@RestController
@RequestMapping("/fact")
public class FactController {
    private FactService factService;

    // Constructor de la clase HeroController
    public FactController(FactService FactService) {
        this.FactService = factService;
    }

    // Metodo para obtener todos los heroes
    @GetMapping
    public ResponseEntity<List<Fact>> getAllFacts() {
        return new ResponseEntity<>(factService.getAllFacts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fact> obtenerFactID(@PathVariable Long id) {
        Fact fact = factService.obtenerHeroID(id);
        if (fact != null) {
            return new ResponseEntity<>(fact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Metodo para borra un heroe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFact(@PathVariable("id") Long id) {
        factService.deletefact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Metodo para crear un heroe
    @PostMapping()
    public ResponseEntity<Fact> createHero(@RequestBody Fact fact) {
        return new ResponseEntity<>(factService.createHero(fact), HttpStatus.CREATED);
    }
}
