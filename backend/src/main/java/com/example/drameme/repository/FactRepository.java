package com.example.drameme.repository;

//Librerias
import com.example.drameme.entity.Fact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio

public interface FactRepository extends JpaRepository<Fact, Long> {
    Fact findById(long id);
    List<Fact> findAllFact();
}