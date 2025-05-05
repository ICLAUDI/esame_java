package com.example.demo.controller;

import com.example.demo.Dto.CategoriaDTO;
import com.example.demo.Mapper.CategoriaMapper;
import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categorie")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Ottieni tutte le categorie
    @GetMapping
    public List<CategoriaDTO> getAll() {
        List<Categoria> categorie = categoriaService.getAllCategorie();
        return categorie.stream()
                        .map(CategoriaMapper::toDTO)  // Mappiamo ogni Categoria in CategoriaDTO
                        .collect(Collectors.toList());
    }

    // Ottieni categoria per ID
    @GetMapping("/{id}")
    public Optional<CategoriaDTO> getById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.getCategoriaById(id);
        return categoria.map(CategoriaMapper::toDTO);  // Se la Categoria esiste, la mappiamo in CategoriaDTO
    }

    // Crea una nuova categoria
    @PostMapping
    public CategoriaDTO create(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = CategoriaMapper.toEntity(categoriaDTO);  // Convertiamo CategoriaDTO in Categoria
        categoria = categoriaService.createCategoria(categoria);  // Salviamo l'entità nel database
        return CategoriaMapper.toDTO(categoria);  // Restituiamo il DTO della Categoria appena creata
    }

    // Aggiorna una categoria esistente
    @PutMapping("/{id}")
    public CategoriaDTO update(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = CategoriaMapper.toEntity(categoriaDTO);  // Convertiamo CategoriaDTO in Categoria
        categoria.setIdCategoria(id);  // Impostiamo l'ID per aggiornare la Categoria
        categoria = categoriaService.updateCategoria(id, categoria);  // Aggiorniamo la Categoria nel database
        return CategoriaMapper.toDTO(categoria);  // Restituiamo il DTO della Categoria aggiornata
    }

    // Elimina una categoria
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);  // Eliminiamo la Categoria dal database
    }

    // Cerca categoria per nome
    @GetMapping("/search/nome")
    public List<CategoriaDTO> searchByNome(@RequestParam String nome) {
        List<Categoria> categorie = categoriaService.searchByNome(nome);
        return categorie.stream()
                        .map(CategoriaMapper::toDTO)  // Mappiamo ogni Categoria in CategoriaDTO
                        .collect(Collectors.toList());
    }

    // Cerca categoria per area tematica
    @GetMapping("/search/area")
    public List<CategoriaDTO> searchByAreaTematica(@RequestParam String areaTematica) {
        List<Categoria> categorie = categoriaService.searchByAreaTematica(areaTematica);
        return categorie.stream()
                        .map(CategoriaMapper::toDTO)  // Mappiamo ogni Categoria in CategoriaDTO
                        .collect(Collectors.toList());
    }
}
