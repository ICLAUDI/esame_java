package com.example.demo.service;

import com.example.demo.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> getAllCategorie();
    Optional<Categoria> getCategoriaById(Long id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Long id, Categoria categoria);
    void deleteCategoria(Long id);
    List<Categoria> searchByNome(String nome);
    List<Categoria> searchByAreaTematica(String areaTematica);
}
