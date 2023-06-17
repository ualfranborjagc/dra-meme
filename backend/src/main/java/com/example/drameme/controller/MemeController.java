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

import com.example.drameme.entity.Meme;
import com.example.drameme.service.MemeService;

@RestController
@RequestMapping("/meme")
public class MemeController {
    private MemeService memeService;

    // Constructor de la clase HeroController
    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping
    public ResponseEntity<List<Meme>> getAllMemes() {
        return new ResponseEntity<>(memeService.getAllMemes(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeme(@PathVariable("id") Long id) {
        memeService.deleteMeme(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<Meme> createFact(@RequestBody Meme meme) {
        return new ResponseEntity<>(memeService.createFact(meme), HttpStatus.CREATED);
    }
}
