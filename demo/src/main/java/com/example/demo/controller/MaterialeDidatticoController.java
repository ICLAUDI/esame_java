package com.example.demo.controller;

import com.example.demo.model.MaterialeDidattico;
import com.example.demo.model.Corso;
import com.example.demo.service.MaterialeDidatticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiali")
public class MaterialeDidatticoController {

    @Autowired
    private MaterialeDidatticoService service;

    @GetMapping
    public List<MaterialeDidattico> getAll() {
        return service.getAllMateriali();
    }

    @GetMapping("/{id}")
    public MaterialeDidattico getById(@PathVariable Long id) {
        return service.getMaterialeById(id);
    }

    @PostMapping
    public MaterialeDidattico create(@RequestBody MaterialeDidattico materiale) {
        return service.createMateriale(materiale);
    }

    @PutMapping("/{id}")
    public MaterialeDidattico update(@PathVariable Long id, @RequestBody MaterialeDidattico materiale) {
        return service.updateMateriale(id, materiale);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteMateriale(id);
    }

    @PostMapping("/corso")
    public List<MaterialeDidattico> getByCorso(@RequestBody Corso corso) {
        return service.getByCorso(corso);
    }

    @GetMapping("/titolo")
    public List<MaterialeDidattico> getByTitolo(@RequestParam String titolo) {
        return service.getByTitolo(titolo);
    }

    @GetMapping("/tipo")
    public List<MaterialeDidattico> getByTipo(@RequestParam String tipo) {
        return service.getByTipo(tipo);
    }
}
