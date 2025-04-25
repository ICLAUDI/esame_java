package com.example.demo.service;

import com.example.demo.model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Categoria saveCategoria(Categoria categoria);
    Categoria getCategoriaById(Long id);
    Optional<Categoria> getCategoriaByNome(String nome);
    List<Categoria> getAllCategorie();
    List<Categoria> getCategorieWithCorsi();
    List<Object[]> getStatisticheCorsiPerCategoria();
    List<Categoria> searchCategorieByKeyword(String keyword);
    void deleteCategoria(Long id);
    boolean existsById(Long id);
}