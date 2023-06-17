package com.example.drameme.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.drameme.entity.Meme;
import com.example.drameme.repository.MemeRepository;

@Service
public class MemeService {
    private MemeRepository memeRepository;
    //Constructor de la clase HeroService
    public MemeService(MemeRepository memeRepository) {
        this.memeRepository = memeRepository;
    }
    //Metodo para obtener todos los heroes
    public Meme getMeme(Long id) {
        return memeRepository.findById(id).get();
    }
    //Metodo para crear un heroe
    public Meme createFact(Meme meme) {
        return memeRepository.save(meme);
    }
    //Metodo para eliminar un heroe
    public void deleteMeme(Long id) {
        memeRepository.deleteById(id);
    }
    //Metodo para obtener todos los heroes
    public List<Meme> getAllMemes() {
        return memeRepository.findAllMeme();
    }
}
