package com.example.products.service;

import com.example.products.model.Estudiante;
import com.example.products.repository.EstudianteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {
    private final EstudianteRepository repo;

    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public List<Estudiante> findAll() {
        return repo.findAll();
    }

    public Optional<Estudiante> findById(Long id) {
        return repo.findById(id);
    }

    public Estudiante save(Estudiante estudiante) {
        estudiante.setId(null);
        return repo.save(estudiante);
    }

    public Optional<Estudiante> update(Long id, Estudiante updated) {
        Optional<Estudiante> result = repo.findById(id);
        if (result.isEmpty()) {
            return Optional.empty();
        }
        Estudiante existing = result.get();
        existing.setNombre(updated.getNombre());
        existing.setMatricula(updated.getMatricula());
        existing.setEdad(updated.getEdad());
        return Optional.of(repo.save(existing));
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
