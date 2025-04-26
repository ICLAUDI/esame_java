package com.example.demo.controller;

import com.example.demo.model.Corso;
import com.example.demo.service.CorsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/corsi")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;

    @GetMapping
    public List<Corso> getAll() {
        return corsoService.getAllCorsi();
    }

    @GetMapping("/{id}")
    public Optional<Corso> getById(@PathVariable Long id) {
        return corsoService.getCorsoById(id);
    }

    @PostMapping
    public Corso create(@RequestBody Corso corso) {
        return corsoService.createCorso(corso);
    }

    @PutMapping("/{id}")
    public Corso update(@PathVariable Long id, @RequestBody Corso corso) {
        return corsoService.updateCorso(id, corso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        corsoService.deleteCorso(id);
    }

    @GetMapping("/search/titolo")
    public List<Corso> searchByTitolo(@RequestParam String titolo) {
        return corsoService.searchByTitolo(titolo);
    }

    @GetMapping("/search/futuri")
    public List<Corso> getCorsiFuturi() {
        return corsoService.getCorsiFuturi();
    }

    @GetMapping("/search/attuali")
    public List<Corso> getCorsiAttuali() {
        return corsoService.getCorsiAttuali();
    }

    @GetMapping("/search/date-inizio")
    public List<Corso> getByDataInizioBetween(@RequestParam Date start, @RequestParam Date end) {
        return corsoService.getByDataInizioBetween(start, end);
    }

    @GetMapping("/search/date-fine")
    public List<Corso> getByDataFineBetween(@RequestParam Date start, @RequestParam Date end) {
        return corsoService.getByDataFineBetween(start, end);
    }

    @GetMapping("/search/posti")
    public List<Corso> getByPostiDisponibiliGreaterThan(@RequestParam Integer minPosti) {
        return corsoService.getByPostiDisponibiliGreaterThan(minPosti);
    }
}
