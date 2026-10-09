package com.example.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.products.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}

