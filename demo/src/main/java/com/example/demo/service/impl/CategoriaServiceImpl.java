package com.example.demo.service.impl;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria non trovata con id: " + id));
    }

    @Override
    public Optional<Categoria> getCategoriaByNome(String nome) {
        return categoriaRepository.findByNome(nome);
    }

    @Override
    public List<Categoria> getAllCategorie() {
        return categoriaRepository.findAll();
    }

    @Override
    public List<Categoria> getCategorieWithCorsi() {
        return categoriaRepository.findCategorieWithCorsi();
    }

    @Override
    public List<Object[]> getStatisticheCorsiPerCategoria() {
        return categoriaRepository.countCorsiPerCategoria();
    }

    @Override
    public List<Categoria> searchCategorieByKeyword(String keyword) {
        return categoriaRepository.findByDescrizioneContaining(keyword);
    }

    @Override
    public void deleteCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Impossibile eliminare, categoria non trovata con id: " + id);
        }
        categoriaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return categoriaRepository.existsById(id);
    }
}