package com.example.demo.controller;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorie")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.getAllCategorie();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.createCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }

    @GetMapping("/search/nome")
    public List<Categoria> searchByNome(@RequestParam String nome) {
        return categoriaService.searchByNome(nome);
    }

    @GetMapping("/search/area")
    public List<Categoria> searchByAreaTematica(@RequestParam String areaTematica) {
        return categoriaService.searchByAreaTematica(areaTematica);
    }
}
