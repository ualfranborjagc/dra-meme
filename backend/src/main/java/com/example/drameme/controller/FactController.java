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
import org.springframework.web.bind.annotation.RestController;

import com.example.drameme.entity.Fact;
import com.example.drameme.service.FactService;

@RestController
@RequestMapping("/fact")
public class FactController {
    private FactService factService;

    // Constructor de la clase HeroController
    public FactController(FactService factService) {
        this.factService = factService;
    }

    @GetMapping
    public ResponseEntity<List<Fact>> getAllFacts() {
        return new ResponseEntity<>(factService.getAllFacts(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFact(@PathVariable("id") Long id) {
        factService.deleteFact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<Fact> createFact(@RequestBody Fact fact) {
        return new ResponseEntity<>(factService.createFact(fact), HttpStatus.CREATED);
    }
}
