package com.example.drameme.repository;

//Librerias
import com.example.drameme.entity.Fact;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio

public interface FactRepository extends JpaRepository<Fact, Long> {
}