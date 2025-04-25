package com.example.demo.controller;

import com.example.demo.model.Categoria;
import com.example.demo.model.Corso;
import com.example.demo.service.CorsoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/corsi")
public class CorsoController {

    private final CorsoService corsoService;

    public CorsoController(CorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @PostMapping
    public Corso createCorso(@RequestBody Corso corso) {
        return corsoService.saveCorso(corso);
    }

    @GetMapping("/{id}")
    public Corso getCorsoById(@PathVariable Long id) {
        return corsoService.getCorsoById(id);
    }

    @GetMapping
    public List<Corso> getAllCorsi() {
        return corsoService.getAllCorsi();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Corso> getCorsiByCategoria(@PathVariable Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);
        return corsoService.getCorsiByCategoria(categoria);
    }

    @GetMapping("/periodo")
    public List<Corso> getCorsiByPeriodo(
            @RequestParam LocalDate dataInizio,
            @RequestParam LocalDate dataFine) {
        return corsoService.getCorsiByPeriodo(dataInizio, dataFine);
    }

    @GetMapping("/recenti")
    public List<Corso> getCorsiRecenti() {
        return corsoService.getCorsiRecenti();
    }

    @GetMapping("/piu-iscrizioni")
    public List<Corso> getCorsiWithMoreThanXIscrizioni(@RequestParam int numeroMinimo) {
        return corsoService.getCorsiWithMoreThanXIscrizioni(numeroMinimo);
    }

    @DeleteMapping("/{id}")
    public void deleteCorso(@PathVariable Long id) {
        corsoService.deleteCorso(id);
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return corsoService.existsById(id);
    }
}
