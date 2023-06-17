package com.example.drameme.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.drameme.entity.Fact;
import com.example.drameme.repository.FactRepository;

@Service
public class FactService {
    private FactRepository factRepository;
    //Constructor de la clase HeroService
    public FactService(FactRepository factRepository) {
        this.factRepository = factRepository;
    }
    //Metodo para obtener todos los heroes
    public Fact getFact(Long id) {
        return factRepository.findById(id).get();
    }
    //Metodo para crear un heroe
    public Fact createFact(Fact fact) {
        return factRepository.save(fact);
    }
    //Metodo para eliminar un heroe
    public void deleteFact(Long id) {
        factRepository.deleteById(id);
    }
    //Metodo para obtener todos los heroes
    public List<Fact> getAllFacts() {
        return factRepository.findAllFact();
    }
}
