package com.example.products.controller;

import com.example.products.model.Curso;
import com.example.products.service.CursoService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        Optional<Curso> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso updated) {
        Optional<Curso> result = service.update(id, updated);
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
