package com.example.demo.controller;

import com.example.demo.model.Docente;
import com.example.demo.service.DocenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docenti")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping
    public Docente createDocente(@RequestBody Docente docente) {
        return docenteService.saveDocente(docente);
    }

    @GetMapping("/{id}")
    public Docente getDocenteById(@PathVariable Long id) {
        return docenteService.getDocenteById(id);
    }

    @GetMapping
    public List<Docente> getAllDocenti() {
        return docenteService.getAllDocenti();
    }

    @GetMapping("/email/{email}")
    public Docente getDocenteByEmail(@PathVariable String email) {
        return docenteService.getDocenteByEmail(email);
    }

    @GetMapping("/specializzazione/{specializzazione}")
    public List<Docente> getDocentiBySpecializzazione(@PathVariable String specializzazione) {
        return docenteService.getDocentiBySpecializzazione(specializzazione);
    }

    @GetMapping("/piu-corsi")
    public List<Docente> getDocentiWithMostCorsi() {
        return docenteService.getDocentiWithMostCorsi();
    }

    @GetMapping("/ordinati-corsi")
    public List<Docente> getDocentiOrderByNumeroCorsi() {
        return docenteService.getDocentiOrderByNumeroCorsi();
    }

    @DeleteMapping("/{id}")
    public void deleteDocente(@PathVariable Long id) {
        docenteService.deleteDocente(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return docenteService.existsById(id);
    }
}
