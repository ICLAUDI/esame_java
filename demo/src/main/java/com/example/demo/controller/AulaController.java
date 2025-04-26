package com.example.demo.controller;

import com.example.demo.model.Aula;
import com.example.demo.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aule")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping
    public List<Aula> getAll() {
        return aulaService.getAllAule();
    }

    @GetMapping("/{id}")
    public Optional<Aula> getById(@PathVariable Long id) {
        return aulaService.getAulaById(id);
    }

    @PostMapping
    public Aula create(@RequestBody Aula aula) {
        return aulaService.saveAula(aula);
    }

    @PutMapping("/{id}")
    public Aula update(@PathVariable Long id, @RequestBody Aula aula) {
        return aulaService.updateAula(id, aula);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        aulaService.deleteAula(id);
    }

    @GetMapping("/search/nome")
    public List<Aula> searchByNome(@RequestParam String nome) {
        return aulaService.searchByNome(nome);
    }

    @GetMapping("/search/edificio")
    public List<Aula> searchByEdificio(@RequestParam String edificio) {
        return aulaService.searchByEdificio(edificio);
    }

    @GetMapping("/search/capacita")
    public List<Aula> searchByCapacita(@RequestParam Integer capacita) {
        return aulaService.searchByCapacita(capacita);
    }

    @GetMapping("/search/accessibile")
    public List<Aula> searchByAccessibile(@RequestParam Boolean accessibile) {
        return aulaService.searchByAccessibile(accessibile);
    }
}
