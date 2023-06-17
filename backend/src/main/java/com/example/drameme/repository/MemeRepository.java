package com.example.drameme.repository;

//Librerias
import com.example.drameme.entity.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio

public interface MemeRepository extends JpaRepository<Meme, Long> {
}