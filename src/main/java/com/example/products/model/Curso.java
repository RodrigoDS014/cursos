package com.example.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Long precio;
    private int duracionHoras;

    public Curso() {
    }

    public Curso(Long id, String nombre, Long precio, int duracionHoras) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.duracionHoras = duracionHoras;
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

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }   

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
}
