package com.example.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String matricula;
    private int edad;

    public Estudiante() {
    }

    public Estudiante(Long id, String nombre, String matricula, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEdad() {
        return edad;
    }   

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

