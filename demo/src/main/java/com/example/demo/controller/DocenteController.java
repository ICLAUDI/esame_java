package com.example.demo.controller;

import com.example.demo.model.Docente;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/docenti")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public List<Docente> getAll() {
        return docenteService.getAllDocenti();
    }

    @GetMapping("/{id}")
    public Optional<Docente> getById(@PathVariable Long id) {
        return docenteService.getDocenteById(id);
    }

    @PostMapping
    public Docente create(@RequestBody Docente docente) {
        return docenteService.createDocente(docente);
    }

    @PutMapping("/{id}")
    public Docente update(@PathVariable Long id, @RequestBody Docente docente) {
        return docenteService.updateDocente(id, docente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        docenteService.deleteDocente(id);
    }

    @GetMapping("/search/nome")
    public List<Docente> searchByNome(@RequestParam String nome) {
        return docenteService.searchByNome(nome);
    }

    @GetMapping("/search/cognome")
    public List<Docente> searchByCognome(@RequestParam String cognome) {
        return docenteService.searchByCognome(cognome);
    }

    @GetMapping("/search/specializzazione")
    public List<Docente> searchBySpecializzazione(@RequestParam String specializzazione) {
        return docenteService.searchBySpecializzazione(specializzazione);
    }

    @GetMapping("/search/email")
    public Optional<Docente> getByEmail(@RequestParam String email) {
        return docenteService.getByEmail(email);
    }
}
