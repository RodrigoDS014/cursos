package com.example.products.service;

import com.example.products.model.Curso;
import com.example.products.repository.CursoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private final CursoRepository repo;

    public CursoService(CursoRepository repo) {
        this.repo = repo;
    }

    public List<Curso> findAll() {
        return repo.findAll();
    }

    public Optional<Curso> findById(Long id) {
        return repo.findById(id);
    }

    public Curso save(Curso curso) {
        curso.setId(null);
        return repo.save(curso);
    }

    public Optional<Curso> update(Long id, Curso updated) {
        Optional<Curso> result = repo.findById(id);
        if (result.isEmpty()) {
            return Optional.empty();
        }
        Curso existing = result.get();
        existing.setNombre(updated.getNombre());
        existing.setPrecio(updated.getPrecio());
        existing.setDuracionHoras(updated.getDuracionHoras());
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
