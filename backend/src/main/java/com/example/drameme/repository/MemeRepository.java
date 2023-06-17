package com.example.drameme.repository;

//Librerias
import com.example.drameme.entity.Meme;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio

public interface MemeRepository extends JpaRepository<Meme, Long> {

    List<Meme> findAllMeme();
}