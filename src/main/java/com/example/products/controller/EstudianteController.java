package com.example.products.controller;

import com.example.products.model.Estudiante;
import com.example.products.service.EstudianteService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> findById(@PathVariable Long id) {
        Optional<Estudiante> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(estudiante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable Long id, @RequestBody Estudiante updated) {
        Optional<Estudiante> result = service.update(id, updated);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
