package com.example.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.products.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    
}

