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
import com.example.drameme.entity.Meme;

@RestController
@RequestMapping("/meme")
public class MemeController {
    private MemeService memeService;

    public MemeController(MemeService MemeService) {
        this.MemeService = memeService;
    }

    @GetMapping
    public ResponseEntity<List<Meme>> getAllMemes() {
        return new ResponseEntity<>(memeService.getAllMemes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meme> obtenerMemeID(@PathVariable Long id) {
        Meme meme = memeService.obtenerMemeID(id);
        if (meme != null) {
            return new ResponseEntity<>(meme, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeme(@PathVariable("id") Long id) {
        memeService.deleteMeme(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<Meme> createHero(@RequestBody Meme meme) {
        return new ResponseEntity<>(memeService.createHero(meme), HttpStatus.CREATED);
    }
}
