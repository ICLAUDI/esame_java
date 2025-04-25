package com.example.demo.controller;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorie")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    @GetMapping("/nome/{nome}")
    public Optional<Categoria> getCategoriaByNome(@PathVariable String nome) {
        return categoriaService.getCategoriaByNome(nome);
    }

    @GetMapping
    public List<Categoria> getAllCategorie() {
        return categoriaService.getAllCategorie();
    }

    @GetMapping("/con-corsi")
    public List<Categoria> getCategorieWithCorsi() {
        return categoriaService.getCategorieWithCorsi();
    }

    @GetMapping("/statistiche")
    public List<Object[]> getStatisticheCorsiPerCategoria() {
        return categoriaService.getStatisticheCorsiPerCategoria();
    }

    @GetMapping("/search")
    public List<Categoria> searchCategorieByKeyword(@RequestParam String keyword) {
        return categoriaService.searchCategorieByKeyword(keyword);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return categoriaService.existsById(id);
    }
}
